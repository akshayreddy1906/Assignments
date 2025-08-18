package com.akshay.spring.services;
import com.akshay.spring.repositories.SchoolRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.akshay.spring.entities.School;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;


	@Override
	public School save(School school) {
		// TODO Auto-generated method stub
		return schoolRepository.save(school);
	}


	@Override
	public Page<School> findAllSchoolsPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return schoolRepository.findAll(pageable);
	}


	@Override
	public School updateSchoolById(Long id, School school) {
		// TODO Auto-generated method stub
		School existedUser=schoolRepository.findById(id).
				orElseThrow(()->new RuntimeException("School with that id Not Present!"+id));
	
		      if(school.getSchoolName()!=null)    
		      {
		    	  existedUser.setSchoolName(school.getSchoolName());
		      }
		      if(school.getSchoolAdress()!=null)
		      {
		    	  existedUser.setSchoolAdress(school.getSchoolAdress());
		      }
		
		return schoolRepository.save(existedUser);
	}


	@Override
	public int countSchools() {
		// TODO Auto-generated method stub
		return schoolRepository.countAllSchools();
	}
}


