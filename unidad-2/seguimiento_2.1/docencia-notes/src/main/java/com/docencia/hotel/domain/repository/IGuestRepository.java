package com.docencia.hotel.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.docencia.hotel.model.Guest;


/**
 * Repositorio para administrar entidades Guest.
 *
 * Responsabilidades principales:
 * - Consultar si una guest existe por su id
 * - Recuperar una guest por id
 * - Recuperar una guest usando un ejemplo parcial
 * - Listar todas las guest
 * - Crear o actualizar una guest
 * - Borrar una guest por id
 * 
 * @author alejandrosalazargonzalez
 * @version 1.0.0
 */
@Repository
public interface IGuestRepository {

    /**
     * Indica si existe una guest con el id dado.
     *
     * @param id identificador unico de la guest
     * @return true si existe una guest con ese id, false en caso contrario
     */
    boolean exists(String id);

    /**
     * Busca una guest por su id.
     *
     * @param id identificador unico de la guest
     * @return la guest encontrada, o null si no existe
     */
    Guest findById(String id);

    /**
     * Busca una guest que coincida con los campos relevantes del ejemplo dado.
     * La estrategia concreta depende de la implementacion (por ejemplo,
     * comparar por titulo o contenido).
     *
     * @param example objeto Guest usado como ejemplo de busqueda
     * @return una guest que cumpla con el criterio, o null si no hay coincidencia
     */
    Guest find(Guest example);

    /**
     * Devuelve todas las guest almacenadas.
     *
     * @return lista con todas las guest
     */
    List<Guest> findAll();

    /**
     * Inserta o actualiza una guest.
     * - Si la guest no tiene id, la implementacion debe generarlo.
     * - Si la guest ya existe, se actualiza.
     *
     * @param guest entidad Guest a guardar
     * @return la guest guardada, incluida la informacion final (por ejemplo el id asignado)
     */
    Guest save(Guest guest);

    /**
     * Elimina la guest con el id indicado.
     *
     * @param id identificador unico de la guest
     * @return true si se borro una guest, false si no existia
     */
    boolean delete(String id);

}
