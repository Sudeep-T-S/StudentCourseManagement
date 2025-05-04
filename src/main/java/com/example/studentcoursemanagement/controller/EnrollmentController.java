package com.example.studentcoursemanagement.controller;

import com.example.studentcoursemanagement.model.Course;
import com.example.studentcoursemanagement.model.Student;
import com.example.studentcoursemanagement.service.IEnrollmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {
    private final IEnrollmentService enrollmentService;

    public EnrollmentController(IEnrollmentService enrollmentService) { // Removed @Autowired
        this.enrollmentService = enrollmentService;
    }

    @PostMapping("/enroll/{studentId}/{courseId}")
    public ResponseEntity<String> enrollStudentInCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        try {
            enrollmentService.enrollStudentInCourse(studentId, courseId);
            return ResponseEntity.ok("Student enrolled in course successfully");
        } catch (IllegalArgumentException | IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/unenroll/{studentId}/{courseId}")
    public ResponseEntity<String> unenrollStudentFromCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        try {
            enrollmentService.unenrollStudentFromCourse(studentId, courseId);
            return ResponseEntity.ok("Student unenrolled from course successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/student/{studentId}/courses")
    public ResponseEntity<List<Course>> getCoursesForStudent(@PathVariable Long studentId) {
        try {
            List<Course> courses = enrollmentService.getCoursesForStudent(studentId);
            return ResponseEntity.ok(courses);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/course/{courseId}/students")
    public ResponseEntity<List<Student>> getStudentsInCourse(@PathVariable Long courseId) {
        try {
            List<Student> students = enrollmentService.getStudentsInCourse(courseId);
            return ResponseEntity.ok(students);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}