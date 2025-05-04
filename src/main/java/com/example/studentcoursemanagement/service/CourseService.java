package com.example.studentcoursemanagement.service;

import com.example.studentcoursemanagement.model.Course;
import com.example.studentcoursemanagement.repository.IRepository;
import com.example.studentcoursemanagement.repository.InMemoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements ICourseService {
    private final IRepository<Course, Long> courseRepository;

    public CourseService() {
        this.courseRepository = new InMemoryRepository<>();
        // Prepopulate some data for testing
        courseRepository.save(new Course(1L, "Mathematics", "Introduction to Algebra"));
        courseRepository.save(new Course(2L, "Physics", "Mechanics and Dynamics"));
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public Course addCourse(Course course) {
        if (course.getId() == null) {
            course.setId(generateCourseId());
        }
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Long id, Course updatedCourse) {
        Course existingCourse = courseRepository.findById(id);
        if (existingCourse == null) {
            throw new IllegalArgumentException("Course not found");
        }
        updatedCourse.setId(id);
        return courseRepository.save(updatedCourse);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.delete(id);
    }

    public IRepository<Course, Long> getCourseRepository() {
        return courseRepository;
    }

    private Long generateCourseId() {
        return (long) (courseRepository.findAll().size() + 1);
    }
}