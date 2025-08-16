package com.wipro.akshay.repositories;


import com.wipro.akshay.entities.BloodRequest;
import com.wipro.akshay.enums.BloodGroup;
import com.wipro.akshay.enums.PriorityLevel;
import com.wipro.akshay.enums.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BloodRequestRepository extends JpaRepository<BloodRequest, Long> {

    @Query("SELECT r FROM BloodRequest r " +
           "WHERE (:bloodGroup IS NULL OR r.bloodGroup = :bloodGroup) " +
           "AND (:status IS NULL OR r.status = :status) " +
           "AND (:priority IS NULL OR r.priority = :priority)")
    List<BloodRequest> filterRequests(BloodGroup bloodGroup, RequestStatus status, PriorityLevel priority);
}

