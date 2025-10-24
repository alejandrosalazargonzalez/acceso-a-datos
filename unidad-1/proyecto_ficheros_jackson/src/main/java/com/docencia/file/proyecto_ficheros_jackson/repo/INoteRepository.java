package com.docencia.file.proyecto_ficheros_jackson.repo;

import java.util.List;
import java.util.Optional;

import com.docencia.file.proyecto_ficheros_jackson.files.model.Note;

public interface INoteRepository {
    public boolean exist(String id);
    public Note findById(String id);
    public Note find(Note note);
    public List<Note> findAll();
    public Note save(Note n);
    public void delete(String id);
}
