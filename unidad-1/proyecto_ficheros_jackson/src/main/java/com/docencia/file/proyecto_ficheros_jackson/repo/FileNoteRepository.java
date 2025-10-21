package com.docencia.file.proyecto_ficheros_jackson.repo;

import com.docencia.file.proyecto_ficheros_jackson.files.model.Note;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class FileNoteRepository implements INoteRepository {

    public String nameFile;
    public FileNoteRepository(){
        this.nameFile = "note-repsository.txt";
        try {
            verificarFichero();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * si existe y no es un repositorio
     * si no existe lo creo
     * @throws IOException
     */
    private void verificarFichero() throws IOException{
        File file = new File(nameFile);
        URL resourceUrl;
        resourceUrl = getClass().getClassLoader().getResource(nameFile);
        if (resourceUrl == null) {
            throw new IOException("el fichero no existe");
        }
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

}