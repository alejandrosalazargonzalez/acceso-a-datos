package com.docencia.personas.repository;

import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.docencia.personas.model.Direccion;
import com.docencia.personas.model.Persona;

@SpringBootTest
@ActiveProfiles
public class PersonaRepositoryTest {

    private PersonaRepository personaRepository;
    private Persona personaColection;
    Persona personaFind;
    String email = "un@email.com";
    String cuidad = "Canarias";
    @Autowired
    public void setPersonaRepository(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @BeforeEach
    void cleanDataBase(){
        personaRepository.deleteAll();  
        Direccion direccion = new Direccion("una calle", cuidad, "38200", cuidad);
        personaColection = new Persona("test", 18, email , direccion);
        personaFind = personaRepository.save(personaColection);
    }

    @Test
    void testFind(){
        Assertions.assertEquals(1,personaRepository.count());
        Assertions.assertNotNull(personaFind);
        Assertions.assertNotNull(personaFind.getId());
    }

    @Test
    void testFindByCiudad() {
        List<Persona> personaOptional = personaRepository.findByCiudad(cuidad);
        Assertions.assertEquals(1, personaOptional.size());
    }

    @Test
    void testFindByEdadBetween() {
        List<Persona> personasOptiona = personaRepository.findByEdadBetween(10, 20);
        Assertions.assertEquals(1, personasOptiona.size());
    }

    @Test
    void testFindByEmail() {
        Optional<Persona> personaOptional = personaRepository.findByEmail(email);
        Persona personaByEmail = personaColection;
        Assertions.assertEquals(personaByEmail, personaColection);
        Assertions.assertNotNull(personaOptional);

    }

    @Test
    void testFindByNombreContainingIgnoreCase() {

    }
}
