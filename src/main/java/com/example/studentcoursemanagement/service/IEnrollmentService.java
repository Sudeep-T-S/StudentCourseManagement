package com.example.studentcoursemanagement.service;

import com.example.studentcoursemanagement.model.Course;
import com.example.studentcoursemanagement.model.Student;
import java.util.List;

public interface IEnrollmentService {
    void enrollStudentInCourse(Long studentId, Long courseId);
    void unenrollStudentFromCourse(Long studentId, Long courseId);
    List<Course> getCoursesForStudent(Long studentId);
    List<Student> getStudentsInCourse(Long courseId);
}