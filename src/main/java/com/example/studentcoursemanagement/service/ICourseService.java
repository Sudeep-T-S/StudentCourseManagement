package com.example.studentcoursemanagement.service;

import com.example.studentcoursemanagement.model.Course;
import java.util.List;

public interface ICourseService {
    List<Course> getAllCourses();
    Course getCourseById(Long id);
    Course addCourse(Course course);
    Course updateCourse(Long id, Course updatedCourse);
    void deleteCourse(Long id);
}