package com.example.studentcoursemanagement.model;

import com.example.studentcoursemanagement.entity.IEntity;
import java.util.ArrayList;
import java.util.List;

public class Student implements IEntity<Long> {
    private Long id;
    private String name;
    private String email;
    private List<Course> courses = new ArrayList<>();

    public Student() {}

    public Student(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', email='" + email + "'}";
    }
}