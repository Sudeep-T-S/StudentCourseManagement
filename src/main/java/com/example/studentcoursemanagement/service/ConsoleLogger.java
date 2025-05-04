package com.example.studentcoursemanagement.service;

import org.springframework.stereotype.Component;

@Component
public class ConsoleLogger implements ILogger {
    @Override
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}