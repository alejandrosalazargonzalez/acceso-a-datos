package com.docencia.file.proyecto_ficheros_jackson.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.docencia.file.proyecto_ficheros_jackson.repo.INoteRepository;

public abstract class ServiceNoteAbstract implements IServiceNote {

    @Autowired
    INoteRepository noteRepository;

    public INoteRepository getNoteRepository() {
        return noteRepository;
    }


}
