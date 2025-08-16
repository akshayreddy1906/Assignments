package com.wipro.akshay.entities;


import com.wipro.akshay.enums.BloodGroup;
import com.wipro.akshay.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class BloodUnit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long unitId;

	@Enumerated(EnumType.STRING)
	private BloodGroup bloodGroup;

	@NotNull(message = "Quantity is required")
	@Min(value = 1, message = "Quantity must be at least 1 unit")
	private Integer Volume;

	@Enumerated(EnumType.STRING)
	private Status status;
	
	@NotNull(message = "donorId is required")
	private Long donorId;

	@NotBlank(message = "location is required")
	private String location;

	
}
