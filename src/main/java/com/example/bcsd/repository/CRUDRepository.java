package com.example.bcsd.repository;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository<ID, T> {
    List<T> findAll();
    Optional<T> findById(ID id);
    T save(T entity);
    T save(ID id, T entity);
    void delete(ID id);
}
