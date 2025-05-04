package com.example.studentcoursemanagement.controller;

import com.example.studentcoursemanagement.service.IAuditService;
import com.example.studentcoursemanagement.service.IAuditService.AuditEntry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/audit")
public class AuditController {
    private final IAuditService auditService;

    public AuditController(IAuditService auditService) { // Removed @Autowired
        this.auditService = auditService;
    }

    @GetMapping
    public List<AuditEntry> getAuditEntries() {
        return auditService.getAuditEntries();
    }
}