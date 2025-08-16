package com.wipro.akshay.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wipro.akshay.dto.DonorDTO;
import com.wipro.akshay.entities.Donor;
import com.wipro.akshay.enums.BloodGroup;

import jakarta.validation.Valid;

public interface DonorService {

	Donor addDonor(@Valid Donor donor);

	Donor updateDonor(Long id, @Valid Donor donor);


	void deleteDonor(Long id);

	List<Donor> getDonorsByFilter(String city, BloodGroup bloodGroup);

	Page<Donor> getDonorsByBloodGroup(BloodGroup bloodGroup, Pageable pageable);

	Donor getDonorById(Long id);

	DonorDTO setDonorDTOByUnitId(Long unitId);

}
