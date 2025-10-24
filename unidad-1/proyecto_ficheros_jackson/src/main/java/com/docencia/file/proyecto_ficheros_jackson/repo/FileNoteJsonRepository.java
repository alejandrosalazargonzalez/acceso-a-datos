package com.docencia.file.proyecto_ficheros_jackson.repo;

import com.docencia.file.proyecto_ficheros_jackson.files.model.Note;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class FileNoteJsonRepository extends FileNoteAbtractRepository{

    private static String nameFile = "note-repository.json";
    private static JsonMapper mapper = new JsonMapper();
    public FileNoteJsonRepository() {
        super(nameFile, mapper);
    }

    
}
