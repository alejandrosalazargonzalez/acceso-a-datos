package com.docencia.hotel.persistance.jpa;

import org.springframework.stereotype.Repository;

import com.docencia.hotel.domain.repository.IHotelRepository;
import com.docencia.hotel.model.Hotel;
import com.docencia.hotel.persistance.abstracts.AbstractJpaRepository;

/**
 *  @author: alejandrosalazargonzalez
 *  @version: 1.0.0
 */
@Repository
public class HotelJpaRepository extends AbstractJpaRepository<Hotel,String> {

    HotelJpaRepository(IHotelRepository repository){
        setRepository(repository);
    }

}
