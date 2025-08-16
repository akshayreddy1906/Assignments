package com.wipro.akshay.entities;

import java.time.LocalDate;

import com.wipro.akshay.enums.BloodGroup;
import com.wipro.akshay.enums.Gender;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Donor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Name is required")
	private String name;

	@NotBlank(message = "City is required")
	private String city;
	
	@Enumerated(EnumType.STRING)
	private Gender gender; 
	
	@Enumerated(EnumType.STRING)
	private BloodGroup bloodGroup;
	
	@NotNull(message = "age must not be empty")
	@Min(value = 18, message = "Age must be at least 18")
	private Integer age;

	@Email(message = "Invalid email format")
	private String email;
	
	private LocalDate lastDonated;

	
}
