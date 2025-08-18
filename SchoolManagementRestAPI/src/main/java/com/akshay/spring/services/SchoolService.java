package com.akshay.spring.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.akshay.spring.entities.School;

public interface SchoolService {

	 School save(School school);

	 Page<School> findAllSchoolsPage(Pageable pageable);

	 public School updateSchoolById(Long id, School school);

	 int countSchools();
	
}
