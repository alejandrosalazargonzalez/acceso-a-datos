package com.docencia.hotel.domain.repository;
import org.springframework.stereotype.Repository;

import com.docencia.hotel.domain.repository.interfaces.IGeneralInteface;
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
public interface IHotelRepository extends IGeneralInteface<Hotel,String>{


}
