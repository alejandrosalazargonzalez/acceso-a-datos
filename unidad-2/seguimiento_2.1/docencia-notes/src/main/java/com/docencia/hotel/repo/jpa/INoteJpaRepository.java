package com.docencia.hotel.repo.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docencia.hotel.model.Hotel;

@Repository
public interface INoteJpaRepository extends JpaRepository<Hotel, String> {

    Optional<Hotel> findFirstByTitle(String title);

}
