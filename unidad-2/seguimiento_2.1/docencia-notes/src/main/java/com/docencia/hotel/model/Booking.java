package com.docencia.hotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String roomId;

    @Column(name = "address")
    private String address;

    public Booking() {}

    public Booking(String id, String title, String content) {
        this.id = id;
        this.roomId = title;
        this.address = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String title) {
        this.roomId = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String content) {
        this.address = content;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Booking other = (Booking) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Note [id=" + id + ", title=" + roomId + ", content=" + address + "]";
    }

}
