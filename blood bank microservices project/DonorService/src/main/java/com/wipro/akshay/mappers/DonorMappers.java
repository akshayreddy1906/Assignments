package com.wipro.akshay.mappers;

import com.wipro.akshay.entities.Donor;
import com.wipro.akshay.dto.DonorDTO;

public class DonorMappers {
    public static DonorDTO toDTO(Donor donor) {
        if (donor == null) return null;
        DonorDTO dto = new DonorDTO();
        dto.setName(donor.getName());
        dto.setEmail(donor.getEmail());
        dto.setCity(donor.getCity());
        dto.setGender(donor.getGender());
        dto.setBloodGroup(donor.getBloodGroup());
        return dto;
    }
}
