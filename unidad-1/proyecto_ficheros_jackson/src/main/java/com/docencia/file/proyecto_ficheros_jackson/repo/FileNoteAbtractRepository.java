package com.docencia.file.proyecto_ficheros_jackson.repo;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.docencia.file.proyecto_ficheros_jackson.files.model.Note;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public abstract class FileNoteAbtractRepository implements INoteRepository {

    public String nameFile;
    private Path path;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    ObjectMapper mapper;

    public FileNoteAbtractRepository(String nameFile, ObjectMapper mapper){
        this.nameFile = nameFile;
        this.mapper = mapper;
        path = verificarFichero();
        //mapper = new XmlMapper();
        //mapper = new JsonMapper();
    }

    /**
     * si existe y no es un repositorio
     * si no existe lo creo
     * @throws IOException
     */
    private Path verificarFichero() {
        URL resourceUrl;
        resourceUrl = getClass().getClassLoader().getResource(nameFile);
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
