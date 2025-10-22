package com.docencia.file.proyecto_ficheros_jackson.repo;

import com.fasterxml.jackson.databind.json.JsonMapper;

public class FileNoteJsonRepository extends FileNoteAbtractRepository{

    private static String nameFile = "nombre-fichero.xml";
    private static JsonMapper mapper = new JsonMapper();
    public FileNoteJsonRepository() {
        super(nameFile, mapper);
    }
    
}
