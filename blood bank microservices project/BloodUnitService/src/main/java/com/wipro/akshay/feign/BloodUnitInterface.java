package com.wipro.akshay.feign;

import com.wipro.akshay.dto.DonorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "DONOR-SERVICE", path = "/donors")
public interface BloodUnitInterface {

  @GetMapping("/exists/{id}")
  boolean donorExists(@PathVariable("id") Long id);

  @GetMapping("/details/{unitId}")
  public DonorDTO getDonorDetailsByUnitId(@PathVariable Long unitId);
}

