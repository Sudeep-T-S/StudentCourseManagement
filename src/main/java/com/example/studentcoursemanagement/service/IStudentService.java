package com.example.studentcoursemanagement.service;

import com.example.studentcoursemanagement.model.Student;
import java.util.List;

public interface IStudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student addStudent(Student student);
    Student updateStudent(Long id, Student updatedStudent);
    void deleteStudent(Long id);
}