package com.docencia.file.proyecto_ficheros_jackson.service;

import java.util.List;
import java.util.Optional;

import com.docencia.file.proyecto_ficheros_jackson.files.model.Note;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlServiceNote implements IServiceNote{

    XmlMapper xmlMapper;


    public XmlServiceNote(){
        xmlMapper = new XmlMapper();
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
            return xmlMapper.writeValueAsString(note);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Note stringToNote(String cadena) {
        try {
            return xmlMapper.readValue(cadena,Note.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
