package com.example.studentcoursemanagement.service;

import com.example.studentcoursemanagement.model.Student;
import com.example.studentcoursemanagement.model.Course;

public class EnrollmentValidator implements IValidator<EnrollmentData> {
    @Override
    public void validate(EnrollmentData enrollmentData) {
        Student student = enrollmentData.getStudent();
        Course course = enrollmentData.getCourse();

        if (student == null || course == null) {
            throw new IllegalArgumentException("Student or Course cannot be null");
        }

        if (student.getCourses().contains(course)) {
            throw new IllegalStateException("Student is already enrolled in this course");
        }
    }
}

class EnrollmentData {
    private final Student student;
    private final Course course;

    public EnrollmentData(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
}