package com.docencia.hotel.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.docencia.hotel.model.Hotel;

/**
 * Repositorio para administrar entidades Hotel.
 *
 * Responsabilidades principales:
 * - Consultar si un hotel existe por su id
 * - Recuperar un hotel por id
 * - Recuperar un hotel usando un ejemplo parcial
 * - Listar todos los hoteles
 * - Crear o actualizar un hotel
 * - Borrar un hotel por id
 * 
 * @author alejandrosalazargonzalez
 * @version 1.0.0
 */
@Repository
public interface IHotelRepository{


        /**
     * Indica si existe un hotel con el id dado.
     *
     * @param id identificador unico del hotel
     * @return true si existe un hotel con ese id, false en caso contrario
     */
    boolean exists(String id);

    /**
     * Busca una hotel por su id.
     *
     * @param id identificador unico del hotel
     * @return hotel encontrada, o null si no existe
     */
    Hotel findById(String id);

    /**
     * Busca un hotel que coincida con los campos relevantes del ejemplo dado.
     * La estrategia concreta depende de la implementacion (por ejemplo,
     * comparar por titulo o contenido).
     *
     * @param example objeto Hotel usado como ejemplo de busqueda
     * @return un hotel que cumpla con el criterio, o null si no hay coincidencia
     */
    Hotel find(Hotel example);

    /**
     * Devuelve todos los hoteles almacenadas.
     *
     * @return lista con todos los hoteles
     */
    List<Hotel> findAll();

    /**
     * Inserta o actualiza un hotel.
     * - Si el hotel no tiene id, la implementacion debe generarlo.
     * - Si el hotel ya existe, se actualiza.
     *
     * @param hotel entidad Hotel a guardar
     * @return el hotel guardada, incluida la informacion final (por ejemplo el id asignado)
     */
    Hotel save(Hotel hotel);

    /**
     * Elimina el hotel con el id indicado.
     *
     * @param id identificador unico del hotel
     * @return true si se borro un hotel, false si no existia
     */
    boolean delete(String id);

}
