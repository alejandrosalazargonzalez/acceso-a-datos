package com.docencia.file.proyecto_ficheros_jackson.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.docencia.file.proyecto_ficheros_jackson.files.model.Note;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class JsonServiceNote extends ServiceNoteAbstract {
    JsonMapper jsonMapper;
    private static Logger logger = LoggerFactory.getLogger(JsonServiceNote.class);

    public JsonServiceNote(){
        jsonMapper = new JsonMapper();
    }

    @Override
    public boolean exist(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exist'");
    }

    @Override
    public Note findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Note> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Note save(Note n, Optional<String> extOpt) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public String noteToString(Note note) {
        try {
            return jsonMapper.writeValueAsString(note);
        } catch (JsonProcessingException e) {
            logger.error("se ha producido un error {}",note, e);
            return null;
        }
    }


    @Override
    public Note stringToNote(String cadena) {
        try {
            return jsonMapper.readValue(cadena,Note.class);
        } catch (JsonProcessingException e) {
            logger.error("se ha producido un error {}", cadena, e);
            return null;
        }
    }

}
