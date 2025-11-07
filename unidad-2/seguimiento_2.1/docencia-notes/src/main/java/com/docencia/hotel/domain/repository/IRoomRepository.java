package com.docencia.hotel.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.docencia.hotel.domain.repository.interfaces.IGeneralInteface;
import com.docencia.hotel.model.Room;


@Repository
public interface IRoomRepository extends IGeneralInteface<Room,String> {

    List<Room> findByHotelId(String hotelId);

}
