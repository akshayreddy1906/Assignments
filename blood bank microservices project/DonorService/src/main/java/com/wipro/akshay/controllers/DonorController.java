package com.wipro.akshay.controllers;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.akshay.dto.DonorDTO;
import com.wipro.akshay.entities.Donor;
import com.wipro.akshay.enums.BloodGroup;
import com.wipro.akshay.exceptions.DonorNotFoundException;
import com.wipro.akshay.services.DonorService;

@RestController
@RequestMapping("/donors")
@RequiredArgsConstructor
public class DonorController {

    private final DonorService donorService;


    @GetMapping("/{id}")
    public Donor getDonorById(@PathVariable Long id) {
      return donorService.getDonorById(id);
    }
    @GetMapping("/exists/{id}")
    public boolean donorExists(@PathVariable Long id) {
      try { donorService.getDonorById(id); return true; }
      catch (DonorNotFoundException ex) { return false; }
    }


    @GetMapping("/details/{unitId}")
    public DonorDTO getDonorDetailsByUnitId(@PathVariable Long unitId) {
		return donorService.setDonorDTOByUnitId(unitId);
    	
    }
  
    
    

    @PostMapping("/add")
    public Donor addDonor(@Valid @RequestBody Donor donor) {
        return donorService.addDonor(donor);
    }

    @PutMapping("/update/{id}")
    public Donor updateDonor(@PathVariable Long id, @RequestBody Donor donor) {
        return donorService.updateDonor(id, donor);
    }
    @GetMapping("/bloodGroup")
    public Page<Donor> getDonorsByBloodGroup(
            @RequestParam  BloodGroup bloodGroup,
            Pageable pageable) {
        return donorService.getDonorsByBloodGroup(bloodGroup, pageable);
    }
    
    @GetMapping("/filterDonors")
    public List<Donor> getDonorsByMatch(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) BloodGroup bloodGroup) {
        return donorService.getDonorsByFilter(city, bloodGroup);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDonor(@PathVariable Long id) {
        donorService.deleteDonor(id);
        return "Donor deleted successfully";
    }
}
