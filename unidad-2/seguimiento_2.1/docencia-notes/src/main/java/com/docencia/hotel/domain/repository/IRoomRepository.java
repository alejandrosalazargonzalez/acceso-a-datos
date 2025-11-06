package com.docencia.hotel.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.docencia.hotel.model.Room;

/**
 * Repositorio para administrar entidades Room.
 *
 * Responsabilidades principales:
 * - Consultar si una room existe por su id
 * - Recuperar una room por id
 * - Recuperar una room usando un ejemplo parcial
 * - Listar todas las rooms
 * - Crear o actualizar una room
 * - Borrar una room por id
 * 
 * @author alejandrosalazargonzalez
 * @version 1.0.0
 */
@Repository
public interface IRoomRepository {

        /**
     * Indica si existe una room con el id dado.
     *
     * @param id identificador unico de la room
     * @return true si existe una room con ese id, false en caso contrario
     */
    boolean exists(String id);

    /**
     * Busca una room por su id.
     *
     * @param id identificador unico de la room
     * @return la room encontrada, o null si no existe
     */
    Room findById(String id);

    /**
     * Busca rooms por la id del hotel.
     *
     * @param id identificador unico de la room
     * @return las room encontradas, o null si no existe
     */
    List<Room> findByHotel(String hotelId);

    /**
     * Busca una room que coincida con los campos relevantes del ejemplo dado.
     * La estrategia concreta depende de la implementacion (por ejemplo,
     * comparar por titulo o contenido).
     *
     * @param example objeto Room usado como ejemplo de busqueda
     * @return una room que cumpla con el criterio, o null si no hay coincidencia
     */
    Room find(Room example);

    /**
     * Devuelve todas las rooms almacenadas.
     *
     * @return lista con todas las rooms
     */
    List<Room> findAll();


    /**
     * Inserta o actualiza una room.
     * - Si la room no tiene id, la implementacion debe generarlo.
     * - Si la room ya existe, se actualiza.
     *
     * @param room entidad Room a guardar
     * @return la room guardada, incluida la informacion final (por ejemplo el id asignado)
     */
    Room save(Room room);

    /**
     * Elimina la room con el id indicado.
     *
     * @param id identificador unico de la room
     * @return true si se borro una room, false si no existia
     */
    boolean delete(String id);


}
