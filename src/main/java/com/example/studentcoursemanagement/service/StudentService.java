package com.example.studentcoursemanagement.service;

import com.example.studentcoursemanagement.model.Student;
import com.example.studentcoursemanagement.repository.IRepository;
import com.example.studentcoursemanagement.repository.InMemoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    private final IRepository<Student, Long> studentRepository;

    public StudentService() {
        this.studentRepository = new InMemoryRepository<Student, Long>(); // Explicitly specify types
        studentRepository.save(new Student(1L, "John Doe", "john.doe@example.com"));
        studentRepository.save(new Student(2L, "Jane Smith", "jane.smith@example.com"));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student addStudent(Student student) {
        if (student.getId() == null) {
            student.setId(generateStudentId());
        }
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student updatedStudent) {
        Student existingStudent = studentRepository.findById(id);
        if (existingStudent == null) {
            throw new IllegalArgumentException("Student not found");
        }
        updatedStudent.setId(id);
        return studentRepository.save(updatedStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.delete(id);
    }

    public IRepository<Student, Long> getStudentRepository() {
        return studentRepository;
    }

    private Long generateStudentId() {
        return (long) (studentRepository.findAll().size() + 1);
    }
}