package com.wipro.akshay.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wipro.akshay.entities.BloodUnit;
import com.wipro.akshay.dto.DonorDTO;
import com.wipro.akshay.enums.BloodGroup;
import com.wipro.akshay.enums.Status;

import jakarta.validation.Valid;

public interface BloodUnitService {
	BloodUnit addBloodUnit(@Valid BloodUnit bloodUnit);
    BloodUnit updateBloodUnit(Long id, BloodUnit bloodUnit);
    BloodUnit getBloodUnitById(Long id);
    Page<BloodUnit> getByBloodGroup(BloodGroup bloodGroup, Pageable pageable);
    List<BloodUnit> getByStatus(Status status);
    List<BloodUnit> filterByBloodGroupAndStatus(BloodGroup bloodGroup, Status status);
    void deleteBloodUnit(Long id);
	public List<Long> findBloodUnits(String bloodGroup);
	DonorDTO getDonorDto(Long unitId);

}
