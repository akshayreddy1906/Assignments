package com.wipro.akshay.services;

import com.wipro.akshay.entities.Notification;

public interface NotificationService {
	 Notification sendNotification(String recipient, String message);
	 Notification getNotificationById(Long id);
}
