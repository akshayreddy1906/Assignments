package com.wipro.akshay.services;


import com.wipro.akshay.entities.BloodRequest;
import com.wipro.akshay.enums.BloodGroup;
import com.wipro.akshay.enums.PriorityLevel;
import com.wipro.akshay.enums.RequestStatus;
import com.wipro.akshay.exceptions.BloodRequestNotFoundException;
import com.wipro.akshay.feign.BloodRequestInterface;
import com.wipro.akshay.repositories.BloodRequestRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BloodRequestServiceImpl implements BloodRequestService {

    private final BloodRequestRepository bloodRequestRepository;
    private final BloodRequestInterface bloodUnitClient;


    private static final Logger logger = LoggerFactory.getLogger(BloodRequestServiceImpl.class);

    @Override
    public BloodRequest createRequest(@Valid BloodRequest bloodRequest) {

        return bloodRequestRepository.save(bloodRequest);
    }

    @Override
    public BloodRequest updateRequest(Long id, BloodRequest bloodRequest) {
        BloodRequest existing = bloodRequestRepository.findById(id)
            .orElseThrow(() -> new BloodRequestNotFoundException("Blood request not found with id " + id));

        if (bloodRequest.getRequesterName() != null) existing.setRequesterName(bloodRequest.getRequesterName());
        if (bloodRequest.getBloodGroup() != null) existing.setBloodGroup(bloodRequest.getBloodGroup());
        if (bloodRequest.getUnitsRequired() != null) existing.setUnitsRequired(bloodRequest.getUnitsRequired());
        if (bloodRequest.getPriority() != null) existing.setPriority(bloodRequest.getPriority());
        if (bloodRequest.getStatus() != null) existing.setStatus(bloodRequest.getStatus());
        if (bloodRequest.getEmail() != null) existing.setEmail(bloodRequest.getEmail());
        if (bloodRequest.getUnitId() != null) existing.setUnitId(bloodRequest.getUnitId());

        return bloodRequestRepository.save(existing);
    }

    @Override
    public BloodRequest getRequestById(Long id) {
        return bloodRequestRepository.findById(id)
            .orElseThrow(() -> new BloodRequestNotFoundException("Blood request not found with id " + id));
    }

    @Override
    public Page<BloodRequest> getAllRequests(Pageable pageable) {
        return bloodRequestRepository.findAll(pageable);
    }

    @Override
    public List<BloodRequest> filterRequests(BloodGroup bloodGroup, RequestStatus status, PriorityLevel priority) {
        return bloodRequestRepository.filterRequests(bloodGroup, status, priority);
    }

    @Override
    public void deleteRequest(Long id) {
        if (!bloodRequestRepository.existsById(id)) {
            throw new BloodRequestNotFoundException("Blood request not found with id " + id);
        }
        bloodRequestRepository.deleteById(id);
    }
    
    
    
    @Override
    public BloodRequest allocateBloodUnit(Long requestId) {
        BloodRequest request = getRequestById(requestId);


        if (request.getUnitId() != null) {
            return request;
        }

        try {

            List<Long> availableUnitIds = bloodUnitClient.findAvailableUnits(request.getBloodGroup().toString());

            
            int unitsNeeded = request.getUnitsRequired() != null ? request.getUnitsRequired() : 1;
            List<Long> unitsToAssign = availableUnitIds.stream().limit(unitsNeeded).collect(Collectors.toList());


        	logger.warn("oustide else if ");
            if (!unitsToAssign.isEmpty() ) {
            	logger.warn("units if {}{}",unitsToAssign,availableUnitIds);
                request.setUnitId(unitsToAssign);

                request.setStatus(RequestStatus.APPROVED);

            } else {

            	logger.warn("units else {}{}",unitsToAssign,availableUnitIds);
                request.setStatus(RequestStatus.REJECTED);
                request.setUnitId(null);
            }
            return bloodRequestRepository.save(request);

        } catch (Exception e) {
            request.setStatus(RequestStatus.REJECTED);
            request.setUnitId(null);
            return bloodRequestRepository.save(request);
        }
    }

    
}
