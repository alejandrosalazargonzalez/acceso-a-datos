package com.docencia.hotel.domain.repository;

import org.springframework.stereotype.Repository;

import com.docencia.hotel.domain.repository.interfaces.IGeneralInteface;
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
public interface IGuestRepository extends IGeneralInteface<Guest,String>  {

}
