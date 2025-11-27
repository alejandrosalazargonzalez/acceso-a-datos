package com.docencia.rest.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Producto {
    private int id;
    private String nombre;
    private BigDecimal precio;
    private int stock;

    private DetalleProducto detallesProducto;

    /**
     * constructor vacio
     */
    public Producto() {
    }

    /**
     * constructor con el id solo
     * 
     * @param id del producto
     */
    public Producto(int id) {
        this.id = id;
    }

    /**
     * constructor sin el id
     * 
     * @param nombre del producto
     * @param precio del producto
     * @param stock  del producto
     */
    public Producto(String nombre, BigDecimal precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        return Objects.equals(this.id, other.id);
    }

}
