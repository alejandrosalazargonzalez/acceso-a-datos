package com.docencia.domain.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import com.docencia.hotel.model.Guest;

class GuestModelTest {

    private Guest guest;
    private Guest guestId;
    private Guest guestCompleto;

    @BeforeEach
    @Transactional
    void beforeEach() {
        guest = new Guest();
        guestId = new Guest("3");
        guestCompleto = new Guest("3", "mar", "mar@gmail.com","+34 716028634");

    }

    @Test
    void modificarGuestTest() {
        guest.setId("4");
        guest.setFullName("Sala");
        guest.setEmail("sala@gmail.com");
        guest.setPhone("+34 671289153");
        
    }

    @Test
    void verificarEqualsTest(){
        Assertions.assertTrue(guestCompleto.equals(guestId));
    }

    @Test
    void verificarNotEqualsTest(){
        Assertions.assertFalse(guest.equals(guestCompleto));
    }


    @Test
    void verificarEqualsNoObjectsTest() {
        Assertions.assertFalse(guest.equals("guest"));
    }

    @Test
    void verificarEqualsObjectTest(){
        Assertions.assertTrue(guestId.equals(guestId));
    }

    @Test
    void verificarHasCodeTest(){
        Assertions.assertNotNull(guest.hashCode());
    }

    @Test
    void verificarGettersTest(){
        Assertions.assertTrue(guestCompleto.getId().equals("3"));
        Assertions.assertTrue(guestCompleto.getFullName().equals("mar"));
        Assertions.assertTrue(guestCompleto.getEmail().equals("mar@gmail.com"));
        Assertions.assertEquals(guestCompleto.getPhone(),"+34 716028634");
    }
}