package com.example.studentcoursemanagement.model;

import com.example.studentcoursemanagement.entity.IEntity;
import java.util.ArrayList;
import java.util.List;

public class Course implements IEntity<Long> {
    private Long id;
    private String name;
    private String description;
    private List<Student> students = new ArrayList<>();

    public Course() {}

    public Course(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{id=" + id + ", name='" + name + "', description='" + description + "'}";
    }
}