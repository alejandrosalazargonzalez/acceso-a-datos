package com.docencia.hotel.persistance.jpa;

import org.springframework.stereotype.Repository;

import com.docencia.hotel.domain.repository.IGuestRepository;
import com.docencia.hotel.model.Guest;
import com.docencia.hotel.persistance.abstracts.AbstractJpaRepository;

/**
 *  @author: alejandrosalazargonzalez
 *  @version: 1.0.0
 */
@Repository
public class GuestJpaRepository extends AbstractJpaRepository<Guest,String> {


    public GuestJpaRepository(IGuestRepository repository){
        setRepository(repository);
    }

}
