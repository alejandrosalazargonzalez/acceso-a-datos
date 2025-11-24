package com.docencia.personas.repository;

import com.docencia.personas.model.Rol;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RolRepository extends MongoRepository<Rol,String>  {
    
}
