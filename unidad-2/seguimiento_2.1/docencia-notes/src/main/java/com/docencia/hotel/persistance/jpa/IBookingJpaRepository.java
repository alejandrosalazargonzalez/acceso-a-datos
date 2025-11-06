package com.docencia.hotel.persistance.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docencia.hotel.model.Booking;

@Repository
public interface IBookingJpaRepository extends JpaRepository<Booking,String> {

}
