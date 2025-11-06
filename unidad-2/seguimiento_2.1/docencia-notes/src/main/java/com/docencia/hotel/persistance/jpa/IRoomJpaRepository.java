
package com.docencia.hotel.persistance.jpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docencia.hotel.model.Room;

/**
 *  @author: alejandrosalazargonzalez
 *  @version: 1.0.0
 */
@Repository
public interface IRoomJpaRepository extends JpaRepository<Room,String> {

}
