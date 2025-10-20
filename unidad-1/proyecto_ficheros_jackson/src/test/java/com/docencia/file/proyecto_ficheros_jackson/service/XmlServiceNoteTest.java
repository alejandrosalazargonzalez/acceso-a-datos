package com.docencia.file.proyecto_ficheros_jackson.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.docencia.file.proyecto_ficheros_jackson.files.model.Note;

class XmlServiceNoteTest {
    XmlServiceNote xmlServiceNote;
    Note note;

    @BeforeEach
    void BeforeEach(){
        xmlServiceNote = new XmlServiceNote();
        note = new Note();
        note.setId("1");
        note.setTitle("Titulo");
        note.setContent("Contenido");
    }

    @Test
    void serializarNote(){
        String noteStr = xmlServiceNote.noteToString(note);
        Note noteTest = xmlServiceNote.stringToNote(noteStr);
        Assertions.assertEquals(note, noteTest,"los elementos deben ser iguales");
    }

    @Test
    void deSerializarNote(){

    }
}
