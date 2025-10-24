package com.docencia.file.proyecto_ficheros_jackson.repo;

import com.docencia.file.proyecto_ficheros_jackson.files.model.Note;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FileNoteRepository extends FileNoteAbtractRepository {

    private Path path;
    public String nameFile;

    public FileNoteRepository(){
        this.nameFile = "note-repsository.txt";
        try {
            this.path = verificarFichero();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * si existe y no es un repositorio
     * si no existe lo creo
     * @throws IOException
     */
    private Path verificarFichero() throws IOException{
        URL resourceUrl;
        resourceUrl = getClass().getClassLoader().getResource(nameFile);
        if (resourceUrl == null) {
            throw new IOException("el fichero no existe");
        }
        return Paths.get(resourceUrl.getPath());
    }

    private List<Note> readAllInternal() {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            if (!Files.exists(path) || Files.size(path) == 0) {
                return new ArrayList<>();
            }
            Note[] arr = xmlMapper.readValue(Files.readAllBytes(path), Note[].class);
            return new ArrayList<>(Arrays.asList(arr));
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo JSON", e);
        }
    }

}