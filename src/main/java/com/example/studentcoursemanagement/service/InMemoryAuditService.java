package com.example.studentcoursemanagement.service;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class InMemoryAuditService implements IAuditService {
    private final List<IAuditService.AuditEntry> auditEntries = new ArrayList<>();

    @Override
    public void recordAudit(String action, Long studentId, Long courseId) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        auditEntries.add(new IAuditService.AuditEntry(action, studentId, courseId, timestamp));
    }

    @Override
    public List<IAuditService.AuditEntry> getAuditEntries() {
        return auditEntries;
    }
}