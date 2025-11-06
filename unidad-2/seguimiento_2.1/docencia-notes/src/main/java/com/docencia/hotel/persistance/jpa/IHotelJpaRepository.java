package com.docencia.hotel.persistance.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docencia.hotel.model.Hotel;

@Repository
public interface IHotelJpaRepository extends JpaRepository<Hotel, String> {


}
