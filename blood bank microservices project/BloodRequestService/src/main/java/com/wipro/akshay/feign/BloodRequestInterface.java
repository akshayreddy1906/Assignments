package com.wipro.akshay.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.wipro.akshay.enums.BloodGroup;


@FeignClient(name = "BLOOD-UNIT-SERVICE", path = "/bloodUnits")
public interface BloodRequestInterface {

	@GetMapping("/units/available")
	public List<Long> findAvailableUnits(@RequestParam("bloodGroup") String bloodGroup);

}
