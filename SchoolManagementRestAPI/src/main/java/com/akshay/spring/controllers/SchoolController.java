package com.akshay.spring.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.akshay.spring.entities.School;
import com.akshay.spring.services.SchoolService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SchoolController {
	
	private final SchoolService schoolService;
	
	@PostMapping("/addNewSchool")
	public  School addSchool(@RequestBody School school) {
		return schoolService.save(school);
	}
	@GetMapping("/getAllSchoolsPage")
	public Page<School> getAllSchoolsc(Pageable pageable) {
		return schoolService.findAllSchoolsPage(pageable);
	}
	@PatchMapping("/patchUpdateSchoolById/{id}")
	public School patchUpdateSchoolById(@PathVariable Long id,@RequestBody School school) {
		return schoolService.updateSchoolById(id,school);
	}
	@GetMapping("/countSchools")
	public int countAllSchools() {
		return schoolService.countSchools();
	}

}
