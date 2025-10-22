package com.docencia.file.proyecto_ficheros_jackson.repo;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class FileNoteXmlRepository extends FileNoteAbtractRepository{

    private static String nameFile = "nombre-fichero.xml";
    private static XmlMapper mapper = new XmlMapper();
    public FileNoteXmlRepository() {
        super(nameFile, mapper);
    }
    
}
