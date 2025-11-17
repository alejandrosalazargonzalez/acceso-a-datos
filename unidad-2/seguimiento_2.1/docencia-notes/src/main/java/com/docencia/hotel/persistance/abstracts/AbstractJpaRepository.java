package com.docencia.hotel.persistance.abstracts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.docencia.hotel.domain.repository.interfaces.IGeneralInteface;
import com.docencia.hotel.persistance.interfaces.ICrudRepository;


/**
 *  @author: alejandrosalazargonzalez
 *  @version: 1.0.0
 */
public abstract class AbstractJpaRepository<T, ID> implements ICrudRepository<T, ID> {

    private IGeneralInteface<T, ID> repository;
    
    @Autowired
    public void setRepository(IGeneralInteface<T, ID> repository) {
        this.repository = repository;
    }
    
    @Override
    public boolean existsById(ID id) {
        if (id == null) {
            return false;
        }
        return repository.existsById(id);
    }

    @Override
    public T  findById(ID id) {
        if (id == null) {
            return null;
        }
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public T save(T entity) {
        if (entity == null) {
            return null;
        }
        return repository.save(entity);
    }

    @Override
    @Transactional
    public boolean deleteById(ID id) {
        return existsById(id);
    }

}
