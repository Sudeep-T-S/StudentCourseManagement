package com.example.studentcoursemanagement.repository;

import com.example.studentcoursemanagement.entity.IEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository<T extends IEntity<ID>, ID> implements IRepository<T, ID> {
    private final Map<ID, T> storage = new HashMap<>();

    @Override
    public T findById(ID id) {
        return storage.get(id);
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public T save(T entity) {
        ID id = entity.getId();
        if (id == null) {
            throw new IllegalArgumentException("Entity ID cannot be null");
        }
        storage.put(id, entity);
        return entity;
    }

    @Override
    public void delete(ID id) {
        storage.remove(id);
    }
}