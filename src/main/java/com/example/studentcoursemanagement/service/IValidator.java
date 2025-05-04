package com.example.studentcoursemanagement.service;

public interface IValidator<T> {
    void validate(T entity);
}