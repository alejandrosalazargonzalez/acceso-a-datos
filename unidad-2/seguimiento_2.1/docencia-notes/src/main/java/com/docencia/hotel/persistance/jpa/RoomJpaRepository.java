
package com.docencia.hotel.persistance.jpa;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.docencia.hotel.domain.repository.IRoomRepository;
import com.docencia.hotel.model.Room;
import com.docencia.hotel.persistance.abstracts.AbstractJpaRepository;

/**
 *  @author: alejandrosalazargonzalez
 *  @version: 1.0.0
 */
@Repository
public class RoomJpaRepository extends AbstractJpaRepository<Room,String> {

    IRoomRepository repository;

    public RoomJpaRepository(IRoomRepository repository){
        setRepository(repository);
        this.repository = repository;
    }
    

    List<Room> findByHotelId(String hotelId){
        return repository.findByHotelId(hotelId);
    }

}
