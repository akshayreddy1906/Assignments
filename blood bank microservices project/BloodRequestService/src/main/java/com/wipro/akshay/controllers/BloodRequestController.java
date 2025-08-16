package com.wipro.akshay.controllers;


import com.wipro.akshay.entities.BloodRequest;
import com.wipro.akshay.enums.BloodGroup;
import com.wipro.akshay.enums.PriorityLevel;
import com.wipro.akshay.enums.RequestStatus;
import com.wipro.akshay.services.BloodRequestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bloodRequests")
@RequiredArgsConstructor
public class BloodRequestController {

    private final BloodRequestService bloodRequestService;

    @PostMapping("/create")
    public BloodRequest createRequest(@Valid @RequestBody BloodRequest bloodRequest) {
        return bloodRequestService.createRequest(bloodRequest);
    }

    @PutMapping("/update/{id}")
    public BloodRequest updateRequest(@PathVariable Long id, @RequestBody BloodRequest bloodRequest) {
        return bloodRequestService.updateRequest(id, bloodRequest);
    }

    @GetMapping("getRequestById/{id}")
    public BloodRequest getRequestById(@PathVariable Long id) {
        return bloodRequestService.getRequestById(id);
    }

    @GetMapping("/getAllRequests")
    public Page<BloodRequest> getAllRequests(Pageable pageable) {
        return bloodRequestService.getAllRequests(pageable);
    }

    @GetMapping("/filter")
    public List<BloodRequest> filterRequests(
            @RequestParam(required = false) BloodGroup bloodGroup,
            @RequestParam(required = false) RequestStatus status,
            @RequestParam(required = false) PriorityLevel priority) {
        return bloodRequestService.filterRequests(bloodGroup, status, priority);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRequest(@PathVariable Long id) {
        bloodRequestService.deleteRequest(id);
        return "Blood request deleted successfully";
    }
    
    
    @GetMapping("/{id}/allocate")
    public BloodRequest allocateUnit(@PathVariable Long id) {
        return bloodRequestService.allocateBloodUnit(id);
    }
}

