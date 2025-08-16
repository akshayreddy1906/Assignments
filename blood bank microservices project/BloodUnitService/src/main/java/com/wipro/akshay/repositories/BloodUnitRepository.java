package com.wipro.akshay.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wipro.akshay.entities.BloodUnit;
import com.wipro.akshay.enums.BloodGroup;
import com.wipro.akshay.enums.Status;

public interface BloodUnitRepository extends JpaRepository<BloodUnit, Long> {

	Page<BloodUnit> findByBloodGroup(BloodGroup bloodGroup, Pageable pageable);
	
    List<BloodUnit> findByStatus(Status status);
    List<BloodUnit> findByBloodGroupAndStatus(BloodGroup bloodGroup, Status status);


    @Query(nativeQuery = true, value = "SELECT unit_id FROM blood_unit WHERE blood_group = :bloodGroup AND status = 'AVAILABLE'")
    List<Long> findUnits( String bloodGroup);


}
