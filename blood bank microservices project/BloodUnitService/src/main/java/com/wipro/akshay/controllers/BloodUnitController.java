package com.wipro.akshay.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import com.wipro.akshay.entities.BloodUnit;
import com.wipro.akshay.dto.DonorDTO;
import com.wipro.akshay.enums.BloodGroup;
import com.wipro.akshay.enums.Status;
import com.wipro.akshay.services.BloodUnitService;
import java.util.List;

@RestController
@RequestMapping("/bloodUnits")
@RequiredArgsConstructor
public class BloodUnitController {

    private final BloodUnitService bloodUnitService;

    private static final Logger logger = LoggerFactory.getLogger(BloodUnitController.class);



    
    @PostMapping("/donate")
    public BloodUnit addBloodUnit(@Valid @RequestBody BloodUnit bloodUnit) {
        return bloodUnitService.addBloodUnit(bloodUnit);
    }

    @PutMapping("/{id}")
    public BloodUnit updateBloodUnit(@PathVariable Long id, @RequestBody BloodUnit bloodUnit) {
        return bloodUnitService.updateBloodUnit(id, bloodUnit);
    }

    @GetMapping("/{id}")
    public BloodUnit getBloodUnitById(@PathVariable Long id) {
        return bloodUnitService.getBloodUnitById(id);
    }

    @GetMapping("/bloodGroup")
    public Page<BloodUnit> getByBloodGroup(@RequestParam BloodGroup bloodGroup, Pageable pageable) {
        return bloodUnitService.getByBloodGroup(bloodGroup, pageable);
    }
    

    @GetMapping("/status")
    public List<BloodUnit> getByStatus(@RequestParam Status status) {
        return bloodUnitService.getByStatus(status);
    }

    @GetMapping("/filter")
    public List<BloodUnit> filterByBloodGroupAndStatus(
            @RequestParam(required = false) BloodGroup bloodGroup,
            @RequestParam(required = false) Status status) {
        return bloodUnitService.filterByBloodGroupAndStatus(bloodGroup, status);
    }

    @DeleteMapping("/{id}")
    public String deleteBloodUnit(@PathVariable Long id) {
        bloodUnitService.deleteBloodUnit(id);
        return "Blood Unit deleted successfully";
    }
    
    //donor service
    @GetMapping("/details/{unitId}")
    public DonorDTO getDonorDTOByUnitid(@PathVariable Long unitId) {
    	return bloodUnitService.getDonorDto(unitId);
    };
    
    //blood request
    @GetMapping("/units/available")
    public List<Long> findAvailableUnits(@RequestParam("bloodGroup") String bloodGroup) {
        logger.warn("bg is" +bloodGroup);
        List <Long> ak = bloodUnitService.findBloodUnits(bloodGroup);

       logger.warn("available"+ak);
        return ak;
    }

}
