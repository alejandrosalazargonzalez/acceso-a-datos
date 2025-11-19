
package com.docencia.personas.services.impliments;

import java.util.List;

import org.springframework.stereotype.Service;

import com.docencia.personas.model.Persona;
import com.docencia.personas.repository.PersonaRepository;
import com.docencia.personas.services.IPersonaServices;

/**
 *  @author: alejandrosalazargonzalez
 *  @version: 1.0.0
 */
@Service
public class PersonaServices implements IPersonaServices {

    private final PersonaRepository personaRepository;

    public PersonaServices(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }
    @Override
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    @Override
    public Persona findById(String id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public boolean deleteById(String id) {
        personaRepository.deleteById(id);
        return true;
    }

}
