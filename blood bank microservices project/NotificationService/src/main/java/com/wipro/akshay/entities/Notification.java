package com.wipro.akshay.entities;

import com.wipro.akshay.enums.NotificationStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationId;

    @NotBlank(message = "Recipient is required")
    private String recipient;

    @NotBlank(message = "Message is required")
    private String message;

    @Enumerated(EnumType.STRING)
    private NotificationStatus status;
}
