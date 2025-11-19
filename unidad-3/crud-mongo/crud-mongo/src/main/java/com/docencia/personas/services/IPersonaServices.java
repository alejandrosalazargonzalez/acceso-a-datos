package com.docencia.personas.services;

import java.util.List;

import com.docencia.personas.model.Persona;

public interface IPersonaServices {
    public List<Persona> findAll();
    public Persona findById(String id);
    public Persona save(Persona persona);
    public boolean deleteById(String id);
}
