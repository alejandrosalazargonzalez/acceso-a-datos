package com.docencia.hotel.domain.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.docencia.hotel.domain.repository.interfaces.IGeneralInteface;
import com.docencia.hotel.model.Booking;


/**
 * Repositorio para administrar entidades Booking.
 *
 * Responsabilidades principales:
 * - Consultar si una booking existe por su id
 * - Recuperar una booking por id
 * - Recuperar una booking usando un ejemplo parcial
 * - Listar todas las booking
 * - Crear o actualizar una booking
 * - Borrar una booking por id
 * 
 * @author alejandrosalazargonzalez
 * @version 1.0.0
 */
@Repository
public interface IBookingRepository extends IGeneralInteface<Booking,String>{

    public List<Date> reservationsBetweenDates(String fechaInicio,String fechaFin,String roomId);
}
