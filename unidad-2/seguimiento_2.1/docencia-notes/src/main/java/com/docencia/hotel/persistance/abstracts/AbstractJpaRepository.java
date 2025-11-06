package com.docencia.hotel.persistance.abstracts;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.docencia.hotel.persistance.interfaces.ICrudRepository;

public abstract class AbstractJpaRepository<T, ID> implements ICrudRepository<T, ID> {

     private final Class<T> repository;
    
    public AbstractJpaRepository(Class<T> repository) {
        this.repository = repository;
    }

    @Override
    public boolean existsById(ID id) {
        return false;
    }

    @Override
    public T findById(ID id) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    @Transactional
    public T save(T entity) {
        return null;
    }

    @Override
    @Transactional
    public boolean deleteById(ID id) {
        if (!existsById(id)) {
            return false;
        }
        return true;
    }
}
