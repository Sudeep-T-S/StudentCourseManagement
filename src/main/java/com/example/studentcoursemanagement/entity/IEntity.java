package com.example.studentcoursemanagement.entity;

public interface IEntity<ID> {
    ID getId();
    void setId(ID id);
}