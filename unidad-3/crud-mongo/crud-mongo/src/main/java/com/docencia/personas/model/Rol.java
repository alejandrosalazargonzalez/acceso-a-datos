package com.docencia.personas.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author: alejandrosalazargonzalez
 * @version: 1.0.0
 */
@Document(collection = "roles")
public class Rol {

    @Id
    private String id;

    @Field("nombre")
    private String nombre;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * constructor por defecto
     */
    public Rol() {
    }

    /**
     * constructor con el id
     * @param id del rol
     */
    public Rol(String id) {
        this.id = id;
    }

    /**
     * Constructor de la clase con argumentos
     * @param id identificador unico
     * @param nombre nombre del rol
     */
    public Rol(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        Rol other = (Rol) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
