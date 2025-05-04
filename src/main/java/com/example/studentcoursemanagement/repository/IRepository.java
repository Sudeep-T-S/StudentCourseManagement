package com.example.studentcoursemanagement.repository;

import com.example.studentcoursemanagement.entity.IEntity;
import java.util.List;

public interface IRepository<T extends IEntity<ID>, ID> {
    T findById(ID id);
    List<T> findAll();
    T save(T entity);
    void delete(ID id);
}