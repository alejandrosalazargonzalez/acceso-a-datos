package com.docencia.file.proyecto_ficheros_jackson.repo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.docencia.file.proyecto_ficheros_jackson.files.model.Note;


public class FileNoteRepositoryTest {
    FileNoteRepository fileNoteRepository;
    Note elemento;
    String id = "00001";
    String titulo = " Mi titulo";
    String contenido = "contenido";
    Note elementoFind; 

    @BeforeAll
    public  void beforeAll(){
        fileNoteRepository = new FileNoteRepository();
        elemento = new Note(id,titulo,contenido);
        elementoFind = fileNoteRepository.find(elemento);
        Assertions.assertNull(elementoFind,"el elemento debe ser null");
    }
    
    @AfterEach
    void afterEach(){
        elementoFind = fileNoteRepository.findById(id);
        Assertions.assertNotNull(elementoFind, "el elemento no debe ser nulo");
    }

    @Test
    void createFileTest(){
        Assertions.assertNotNull(fileNoteRepository, "el repositorio no debe ser nulo");
    }

    @Test
    void insertNote(){
        Note result = fileNoteRepository.findById(null);
        Assertions.assertNotNull(result, "el resultado no deve de ser nulo");
        Assertions.assertEquals(result, result, "el valor no es el esperado");
        
    }
}
