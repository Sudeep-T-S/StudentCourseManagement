package com.example.studentcoursemanagement.service;

import java.util.List;

public interface IAuditService {
    void recordAudit(String action, Long studentId, Long courseId);
    List<AuditEntry> getAuditEntries();

    class AuditEntry {
        private final String action;
        private final Long studentId;
        private final Long courseId;
        private final String timestamp;

        public AuditEntry(String action, Long studentId, Long courseId, String timestamp) {
            this.action = action;
            this.studentId = studentId;
            this.courseId = courseId;
            this.timestamp = timestamp;
        }

        public String getAction() { return action; }
        public Long getStudentId() { return studentId; }
        public Long getCourseId() { return courseId; }
        public String getTimestamp() { return timestamp; }
    }
}