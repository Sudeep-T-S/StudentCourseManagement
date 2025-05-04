package com.example.studentcoursemanagement.service;

import org.springframework.stereotype.Component;

@Component
public class ConsoleNotificationService implements INotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("[NOTIFICATION] " + message);
    }
}