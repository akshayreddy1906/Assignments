package com.wipro.akshay.services;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.wipro.akshay.entities.BloodUnit;
import com.wipro.akshay.dto.DonorDTO;
import com.wipro.akshay.enums.BloodGroup;
import com.wipro.akshay.enums.Status;
import com.wipro.akshay.exceptions.BloodUnitNotFoundException;
import com.wipro.akshay.exceptions.DonorNotFoundException;
import com.wipro.akshay.feign.BloodUnitInterface;
import com.wipro.akshay.repositories.BloodUnitRepository;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BloodUnitServiceImpl implements BloodUnitService {

    private final BloodUnitRepository bloodUnitRepository;

    private final BloodUnitInterface donorClient; 

    @Override
    public BloodUnit addBloodUnit(@Valid BloodUnit unit) {
      if (!donorClient.donorExists(unit.getDonorId())) {
    	  
        throw new DonorNotFoundException("Invalid donorId: " + unit.getDonorId());
      }
        return bloodUnitRepository.save(unit);
      }
    
    @Override
    public BloodUnit updateBloodUnit(Long id, BloodUnit bloodUnit) {
        BloodUnit existing = bloodUnitRepository.findById(id)
                .orElseThrow(() -> new BloodUnitNotFoundException("Blood Unit not found with id " + id));

        if (bloodUnit.getBloodGroup() != null) existing.setBloodGroup(bloodUnit.getBloodGroup());
        if (bloodUnit.getVolume() != null) existing.setVolume(bloodUnit.getVolume());
        if (bloodUnit.getStatus() != null) existing.setStatus(bloodUnit.getStatus());
        if (bloodUnit.getDonorId() != null) existing.setDonorId(bloodUnit.getDonorId());
        if (bloodUnit.getLocation() != null) existing.setLocation(bloodUnit.getLocation());
        
        return bloodUnitRepository.save(existing);
    }

    @Override
    public BloodUnit getBloodUnitById(Long id) {
        return bloodUnitRepository.findById(id)
            .orElseThrow(() -> new BloodUnitNotFoundException("Blood Unit not found with id " + id));
    }

    public Page<BloodUnit> getByBloodGroup(BloodGroup bloodGroup, Pageable pageable) {
        return bloodUnitRepository.findByBloodGroup(bloodGroup, pageable);
    }

    @Override
    public List<BloodUnit> getByStatus(Status status) {
        return bloodUnitRepository.findByStatus(status);
    }

    @Override
    public List<BloodUnit> filterByBloodGroupAndStatus(BloodGroup bloodGroup, Status status) {
        return bloodUnitRepository.findByBloodGroupAndStatus(bloodGroup, status);
    }

    @Override
    public void deleteBloodUnit(Long id) {
        if (!bloodUnitRepository.existsById(id)) {
            throw new BloodUnitNotFoundException("Blood Unit not found with id " + id);
        }
        bloodUnitRepository.deleteById(id);
    }
    //bloodrequest
	@Override
	public List<Long> findBloodUnits(String bloodGroup) {
		return bloodUnitRepository.findUnits(bloodGroup);
	}
	//donor service
	@Override
	public DonorDTO getDonorDto(Long unitId) {
		return donorClient.getDonorDetailsByUnitId(unitId);
	}
}
