package com.wipro.akshay.repositories;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wipro.akshay.entities.Donor;
import com.wipro.akshay.enums.BloodGroup; 

public interface DonorRepository extends JpaRepository<Donor, Long>{

	@Query("SELECT d FROM Donor d WHERE (:city IS NULL OR d.city = :city) " +
		       "AND (:bloodGroup IS NULL OR d.bloodGroup = :bloodGroup)")
		List<Donor> findByCityAndBloodGroup(String city, BloodGroup bloodGroup);


	Page<Donor> findByBloodGroup(BloodGroup bloodGroup, Pageable pageable);

}
