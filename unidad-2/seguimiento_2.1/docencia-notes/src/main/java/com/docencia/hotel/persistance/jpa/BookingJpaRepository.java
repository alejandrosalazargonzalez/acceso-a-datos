package com.docencia.hotel.persistance.jpa;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.docencia.hotel.domain.repository.IBookingRepository;
import com.docencia.hotel.model.Booking;
import com.docencia.hotel.persistance.abstracts.AbstractJpaRepository;
/**
 *  @author: alejandrosalazargonzalez
 *  @version: 1.0.0
 */
@Repository
public class BookingJpaRepository extends AbstractJpaRepository<Booking, String>  {

    IBookingRepository repository;

    public BookingJpaRepository(IBookingRepository repository) {
        setRepository(repository);
        this.repository = repository;
    }

    public List<Date> reservationsBetweenDates(String fechaInicio,String fechaFin,String roomId){
        return repository.reservationsBetweenDates(fechaInicio, fechaFin, roomId);
    }

}
