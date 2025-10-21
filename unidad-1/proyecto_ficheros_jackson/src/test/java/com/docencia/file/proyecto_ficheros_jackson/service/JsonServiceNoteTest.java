package com.docencia.file.proyecto_ficheros_jackson.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.docencia.file.proyecto_ficheros_jackson.files.model.Note;

class JsonServiceNoteTest {
    JsonServiceNote jsonServiceNote;
    Note note;

    @BeforeEach
    void BeforeEach(){
        jsonServiceNote = new JsonServiceNote();
        note = new Note();
        note.setId("1");
        note.setTitle("Titulo");
        note.setContent("Contenido");
    }

    @Test
    void serializarNote(){
        String noteStr = jsonServiceNote.noteToString(note);
        Note noteTest = jsonServiceNote.stringToNote(noteStr);
        Assertions.assertEquals(note, noteTest,"los elementos deben ser iguales");
    }

    @Test
    void deSerializarNote(){

    }
}
