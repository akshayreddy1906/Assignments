package com.wipro.akshay.services;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wipro.akshay.dto.DonorDTO;
import com.wipro.akshay.entities.Donor;
import com.wipro.akshay.enums.BloodGroup;
import com.wipro.akshay.exceptions.DonorNotFoundException;
import com.wipro.akshay.mappers.DonorMappers;
import com.wipro.akshay.repositories.DonorRepository;

import jakarta.validation.Valid;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DonorServiceImpl implements DonorService {

    private final DonorRepository donorRepository;

    @Override
    public Donor addDonor(@Valid Donor donor) {
        return donorRepository.save(donor);
    }

    @Override
    public Donor updateDonor(Long id, Donor donor) {
        Donor existing = donorRepository.findById(id)
                .orElseThrow(() -> new DonorNotFoundException("Donor not found"));

        if (donor.getName() != null) {
            existing.setName(donor.getName());
        }
        if (donor.getBloodGroup() != null) {
            existing.setBloodGroup(donor.getBloodGroup());
        }
        if (donor.getGender() != null) {
            existing.setGender(donor.getGender());
        }
        if (donor.getCity() != null) {
            existing.setCity(donor.getCity());
        }
        if (donor.getAge() != null) {
            existing.setAge(donor.getAge());
        }
        if (donor.getEmail() != null) {
            existing.setEmail(donor.getEmail());
        }
        if (donor.getLastDonated() != null) {
            existing.setLastDonated(donor.getLastDonated());
        }

        return donorRepository.save(existing);
    }
    
    @Override
    public Page<Donor> getDonorsByBloodGroup(BloodGroup bloodGroup, Pageable pageable) {
        return donorRepository.findByBloodGroup(bloodGroup, pageable);
    }


    @Override
    public List<Donor> getDonorsByFilter(String city, BloodGroup bloodGroup) {
        return donorRepository.findByCityAndBloodGroup(city, bloodGroup);
    }


	@Override
	public void deleteDonor(Long id) {
		if (!donorRepository.existsById(id)) {
	        throw new DonorNotFoundException("Donor not found");
	    }
		 donorRepository.deleteById(id);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Donor getDonorById(Long id) {
		if (!donorRepository.existsById(id)) {
	        throw new DonorNotFoundException("Donor not found");
	    }

		return donorRepository.getById(id);
	}

	
	
	


	@Override
	public DonorDTO setDonorDTOByUnitId(Long unitId) {
		
		Donor donor = donorRepository.getById(unitId);
		 return DonorMappers.toDTO(donor);
	}
}

