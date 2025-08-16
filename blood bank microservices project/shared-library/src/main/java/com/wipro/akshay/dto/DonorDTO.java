package com.wipro.akshay.dto;

import com.wipro.akshay.enums.BloodGroup;
import com.wipro.akshay.enums.Gender;

import lombok.Data;

@Data
public class DonorDTO {
		private String name;
	    private String email;
	    private String city;
	    private Gender gender;
	    private BloodGroup bloodGroup;
}

