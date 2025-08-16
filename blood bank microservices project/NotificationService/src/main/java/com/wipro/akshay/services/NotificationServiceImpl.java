package com.wipro.akshay.services;

import com.wipro.akshay.entities.Notification;
import com.wipro.akshay.enums.NotificationStatus;
import com.wipro.akshay.repositories.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Override
    public Notification sendNotification(String recipient, String message) {
        Notification notification = new Notification();
        notification.setRecipient(recipient);
        notification.setMessage(message);
        notification.setStatus(NotificationStatus.SENT);
        return notificationRepository.save(notification);
    }

    @Override
    public Notification getNotificationById(Long id) {
        return notificationRepository.findById(id).orElse(null);
    }
}
