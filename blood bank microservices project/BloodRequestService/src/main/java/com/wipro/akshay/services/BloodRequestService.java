package com.wipro.akshay.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wipro.akshay.entities.BloodRequest;
import com.wipro.akshay.enums.BloodGroup;
import com.wipro.akshay.enums.PriorityLevel;
import com.wipro.akshay.enums.RequestStatus;

public interface BloodRequestService {
    BloodRequest createRequest(BloodRequest bloodRequest);
    BloodRequest updateRequest(Long id, BloodRequest bloodRequest);
    BloodRequest getRequestById(Long id);
    Page<BloodRequest> getAllRequests(Pageable pageable);
    List<BloodRequest> filterRequests(BloodGroup bloodGroup, RequestStatus status, PriorityLevel priority);
    void deleteRequest(Long id);
    
    
	BloodRequest allocateBloodUnit(Long requestId);
}
