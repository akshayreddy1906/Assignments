package com.wipro.akshay.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.akshay.entities.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
