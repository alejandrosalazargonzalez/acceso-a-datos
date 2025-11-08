package com.docencia.hotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Objects;

/**
 *  @author: alejandrosalazargonzalez
 *  @version: 1.0.0
 */

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @Column(name = "id",nullable = false)
    private String id;

    @Column(name = "check_in")
    private String checkIn;

    @Column(name = "check_out")
    private String checkOut;

    @OneToMany
    @JoinColumn(name = "room_id")
    private String roomId;

    @OneToOne
    @JoinColumn(name = "guest_id")
    private String guestId;

    public Booking() {
    }

    public Booking(String id){
        this.id = id;
    }

    public Booking(String id, String checkIn, String checkOut, String roomId, String guestId) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.roomId = roomId;
        this.guestId = guestId;
    }

    public Booking(String id, String checkIn, String checkOut, Guest guest, Room room) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.guestId = guest.getId();
        this.roomId = room.getId();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCheckIn() {
        return this.checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return this.checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getGuestId() {
        return this.guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public Booking id(String id) {
        setId(id);
        return this;
    }

    public Booking checkIn(String checkIn) {
        setCheckIn(checkIn);
        return this;
    }

    public Booking checkOut(String checkOut) {
        setCheckOut(checkOut);
        return this;
    }

    public Booking roomId(String roomId) {
        setRoomId(roomId);
        return this;
    }

    public Booking guestId(String guestId) {
        setGuestId(guestId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Booking)) {
            return false;
        }
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Booking [id=" + id + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", roomId=" + roomId
                + ", guestId=" + guestId + "]";
    }

}
