package com.wipro.akshay.entities;

import java.util.List;

import com.wipro.akshay.enums.BloodGroup;
import com.wipro.akshay.enums.RequestStatus;
import com.wipro.akshay.enums.PriorityLevel;

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
public class BloodRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    @NotBlank(message = "Requester name is required") 
    private String requesterName;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Blood group is required")
    private BloodGroup bloodGroup;

    @NotNull(message = "Units required must be specified")
    @Min(value = 1, message = "At least 1 unit is required")
    private Integer unitsRequired;

    @Enumerated(EnumType.STRING)
    private PriorityLevel priority; 

    @Enumerated(EnumType.STRING)
    private RequestStatus status; 
    
    @Email(message="provide valid email")
    private String email;

    private List<Long> unitId;
 
}
