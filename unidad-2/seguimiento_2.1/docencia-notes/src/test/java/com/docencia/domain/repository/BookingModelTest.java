package com.docencia.domain.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import com.docencia.hotel.model.Booking;
import com.docencia.hotel.model.Guest;
import com.docencia.hotel.model.Room;

class BookingModelTest {

    private Booking booking;
    private Booking bookingId;
    private Booking bookingCompleto;
    private String fechaEntrada;
    private String fechaSalida;
    private Guest guest;
    private Room room;

    @BeforeEach
    @Transactional
    void beforeEach() {

        fechaEntrada = "2025, 9, 23";
        fechaSalida = "2025, 9, 25";
        guest = new Guest();
        room = new Room();
        booking = new Booking();
        bookingId = new Booking("3");
        bookingCompleto = new Booking("3", fechaEntrada, fechaSalida,guest,room);
    }

    @Test
    void modificarBookingTest() {
        booking.setId("5");
        booking.setCheckIn("2025, 9, 24");
        booking.setCheckOut("2025, 9, 27");
        booking.setGuestId(guest.getId());
        booking.setRoomId(room.getId());
    }

    @Test
    void verificarEqualsTest(){
        Assertions.assertTrue(bookingCompleto.equals(bookingId));
    }

    @Test
    void verificarNotEqualsTest(){
        Assertions.assertFalse(booking.equals(bookingCompleto));
    }

    @Test
    void verificarEqualsNoObjectsTest() {
        Assertions.assertFalse(booking.equals("Booking"));
    }

    @Test
    void verificarEqualsObjectTest(){
        Assertions.assertTrue(bookingId.equals(bookingId));
    }

    @Test
    void verificarHasCodeTest(){
        Assertions.assertNotNull(booking.hashCode());
    }

    @Test
    void verificarGettersTest(){
        Assertions.assertTrue(bookingCompleto.getId().equals("3"));
        Assertions.assertTrue(bookingCompleto.getCheckIn().equals(fechaEntrada));
        Assertions.assertTrue(bookingCompleto.getCheckOut().equals(fechaSalida));
        Assertions.assertNull(bookingCompleto.getGuestId());
        Assertions.assertNull(bookingCompleto.getRoomId());
    }
}