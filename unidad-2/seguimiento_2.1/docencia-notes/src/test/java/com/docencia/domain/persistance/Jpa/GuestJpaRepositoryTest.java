package com.docencia.domain.persistance.Jpa;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.docencia.hotel.domain.repository.IGuestRepository;
import com.docencia.hotel.model.Guest;

import jakarta.transaction.Transactional;

@SpringBootTest
@ActiveProfiles("test")
class GuestJpaRepositoryTest {
    
    @Autowired
    private IGuestRepository GuestRepository;

    private Guest GuestBase;

    @BeforeEach
    @Transactional
    void beforeEach(){
        GuestBase = new Guest("3", "Nico", "nicolas@gmail.com", "633158769");
        
        assertThat(GuestBase.getId()).isNotNull();
    }


    @Test
    @Transactional
    void saveNullTest(){
        Guest guest = new Guest();
        Guest guestsaved = GuestRepository.save(guest);
        
        Assertions.assertNotNull(guestsaved);
    }

    @Test
    @Transactional
    void saveBlankTest(){
        Guest guest = new Guest("");
        Guest guestsaved = GuestRepository.save(guest);
        
        Assertions.assertNotNull(guestsaved);
    }

    @Test
    @Transactional
    void findByIdTest(){
        GuestRepository.save(GuestBase);
        String id = GuestBase.getId();
        boolean exist = GuestRepository.existsById(id);
        assertThat(exist).isTrue();
    }

    @Test
    @Transactional
    void findAllTest(){
        int tamanio = GuestRepository.findAll().size();
        Assertions.assertEquals( 2,tamanio);
        GuestRepository.save(GuestBase);
        Assertions.assertEquals( 3,GuestRepository.findAll().size());

    }


    @Test
    @Transactional
    void deleteByIdTest(){
        GuestRepository.save(GuestBase);
        String id = GuestBase.getId();
        GuestRepository.deleteById(id);
        assertThat(GuestRepository.existsById(id)).isFalse();
        assertThat(GuestRepository.findById(id)).isNull();
    }

    @Test
    @Transactional
    void deleteDontExistId(){
        GuestRepository.deleteById("jhjhghje");
    }
}