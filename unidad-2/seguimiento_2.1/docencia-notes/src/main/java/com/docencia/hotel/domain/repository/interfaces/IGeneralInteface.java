package com.docencia.hotel.domain.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IGeneralInteface <T,ID> extends JpaRepository<T,ID>{
    
}
