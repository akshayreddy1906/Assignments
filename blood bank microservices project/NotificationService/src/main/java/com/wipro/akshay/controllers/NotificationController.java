package com.wipro.akshay.controllers;

import com.wipro.akshay.entities.Notification;
import com.wipro.akshay.services.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    public Notification sendNotification(@RequestParam String recipient, @RequestParam String message) {
        return notificationService.sendNotification(recipient, message);
    }

    @GetMapping("/{id}")
    public Notification getNotification(@PathVariable Long id) {
        return notificationService.getNotificationById(id);
    }
}
