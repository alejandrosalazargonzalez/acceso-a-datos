package com.docencia.domain.persistance.Jpa;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;

import com.docencia.hotel.domain.repository.IHotelRepository;
import com.docencia.hotel.domain.repository.IRoomRepository;
import com.docencia.hotel.model.Hotel;
import com.docencia.hotel.model.Room;

import jakarta.transaction.Transactional;

@SpringBootTest
@ActiveProfiles("test")
class RoomJpaRepositoryTest {

    @Autowired
    private IRoomRepository roomRepository;

    @Autowired
    private IHotelRepository hotelRepository;

    private Room roomBase;
    private Hotel hotelBase;
    private Hotel savedHotel;
    private Room savedRoom;

    @BeforeEach
    @Transactional
    void beforeEach() {
        hotelBase = new Hotel("5", "Las palmas", "Las palmas");
        roomBase = new Room("3", 4, "nico", 253, hotelBase.getId());
        assertThat(roomBase.getId()).isNotNull();
        assertThat(hotelBase.getId()).isNotNull();
        savedHotel = hotelRepository.save(hotelBase);
        savedRoom = roomRepository.save(roomBase);
    }

    @Test
    @Transactional
    void saveValidRoomTest() {
        
        assertThat(savedRoom).isNotNull();
        assertThat(savedRoom.getId()).isNotNull();
    }

    @Test
    @Transactional
    void saveNullTest() {
        Room room = new Room(); 
        try {
            roomRepository.save(room);
            Assertions.fail("La Excepcion no fue lanzada.");
        } catch (DataIntegrityViolationException expectedException) {}
    }

    @Test
    @Transactional
    void saveBlankTest() {
        Room roomWithBlankId = new Room("", 4, "test", 253, savedHotel.getId());
        Room savedRoom = roomRepository.save(roomWithBlankId);
        Assertions.assertNotNull(savedRoom);
        assertThat(savedRoom.getId()).isNotBlank();
    }

    @Test
    @Transactional
    void findByIdTest(){
        roomRepository.save(savedRoom);
        String id = roomBase.getId();
        Optional<Room> exist = roomRepository.findById(id);
        Assertions.assertNotNull(exist);
    }

    @Test
    @Transactional
    void findAllTest() {
        roomBase.setHotelId(savedHotel.getId());
        roomRepository.save(roomBase);

        int finalCount = roomRepository.findAll().size();

        assertThat(finalCount).isGreaterThanOrEqualTo(1);
    }

    @Test
    @Transactional
    void deleteByIdTest() {
        roomBase.setHotelId(savedHotel.getId());
        roomRepository.save(roomBase);

        String id = roomBase.getId();
        roomRepository.deleteById(id);

        assertThat(roomRepository.existsById(id)).isFalse();

    }

    
    @Test
    @Transactional
    void findByHotelIdTest(){
        roomRepository.save(savedRoom);
        Hotel hoteSaved = hotelRepository.save(hotelBase);
        String id = hoteSaved.getId();
        List<Room> exist = roomRepository.findByHotelId(id);
        Assertions.assertNotNull(exist);
    }
        
    @Test
    @Transactional
    void deleteDontExistId() {
        roomRepository.deleteById("jhjhghje");
    }
}