package com.docencia.hotel.domain.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

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
public interface IBookingRepository {


    /**
     * Indica si existe una booking con el id dado.
     *
     * @param id identificador unico de la booking
     * @return true si existe una booking con ese id, false en caso contrario
     */
    boolean exists(String id);

    /**
     * Busca una booking por su id.
     *
     * @param id identificador unico de la booking
     * @return la booking encontrada, o null si no existe
     */
    Booking findById(String id);

    /**
     * Devuelve todas las booking entre dos fechas.
     *
     * @return lista con todas las booking
     */
    List<Booking> findBetweenDates(Date startDate, Date endDate, String roomNumber, String hotel);

    /**
     * Busca una booking que coincida con los campos relevantes del ejemplo dado.
     * La estrategia concreta depende de la implementacion (por ejemplo,
     * comparar por titulo o contenido).
     *
     * @param example objeto Booking usado como ejemplo de busqueda
     * @return una booking que cumpla con el criterio, o null si no hay coincidencia
     */
    Booking find(Booking example);

    /**
     * Devuelve todas las booking almacenadas.
     *
     * @return lista con todas las booking
     */
    List<Booking> findAll();

    /**
     * Inserta o actualiza una booking.
     * - Si la booking no tiene id, la implementacion debe generarlo.
     * - Si la booking ya existe, se actualiza.
     *
     * @param booking entidad Booking a guardar
     * @return la booking guardada, incluida la informacion final (por ejemplo el id asignado)
     */
    Booking save(Booking booking);

    /**
     * Elimina la booking con el id indicado.
     *
     * @param id identificador unico de la booking
     * @return true si se borro una booking, false si no existia
     */
    boolean delete(String id);

}
