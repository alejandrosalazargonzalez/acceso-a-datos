package com.docencia.domain.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import com.docencia.hotel.model.Hotel;
import com.docencia.hotel.model.Room;

class RoomModelTest {

    private Room room;
    private Room roomId;
    private Room roomCompleto;
    private Hotel hotel;

    @BeforeEach
    @Transactional
    void beforeEach() {
        hotel = new Hotel("5");
        room = new Room();
        roomId = new Room("3");
        roomCompleto = new Room("3", 205, "single",15, hotel.getId());

    }

    @Test
    void modificarroomTest() {
        room.setId("5");
        room.setNumber(25);
        room.setPricePerNight(250);
        room.setType("double");
    }

    @Test
    void verificarEqualsTest(){
        Assertions.assertTrue(roomCompleto.equals(roomId));
    }

    @Test
    void verificarNotEqualsTest(){
        Assertions.assertFalse(room.equals(roomCompleto));
    }


    @Test
    void verificarEqualsNoObjectsTest() {
        Assertions.assertFalse(room.equals("room"));
    }

    @Test
    void verificarEqualsObjectTest(){
        Assertions.assertTrue(roomId.equals(roomId));
    }

    @Test
    void verificarHasCodeTest(){
        Assertions.assertNotNull(room.hashCode());
    }

    @Test
    void verificarGettersTest(){
        Assertions.assertTrue(roomCompleto.getId().equals("3"));
        Assertions.assertTrue(roomCompleto.getType().equals("single"));
        Assertions.assertTrue(roomCompleto.getNumber() == 205);
        Assertions.assertTrue(roomCompleto.getPricePerNight() == 15);
    }
}