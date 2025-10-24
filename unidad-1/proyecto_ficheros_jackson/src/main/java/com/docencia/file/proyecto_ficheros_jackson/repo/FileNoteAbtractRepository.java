package com.docencia.file.proyecto_ficheros_jackson.repo;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.docencia.file.proyecto_ficheros_jackson.files.model.Note;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import io.micrometer.common.util.StringUtils;

public abstract class FileNoteAbtractRepository implements INoteRepository {

    public String nameFile;
    private Path path;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    ObjectMapper mapper;

    public FileNoteAbtractRepository(){ }

    public FileNoteAbtractRepository(String nameFile, ObjectMapper mapper){
        this.nameFile = nameFile;
        this.mapper = mapper;
        path = verificarFichero();
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

    @Override
    public boolean exist(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exist'");
    }
    
    @Override
    public Note findById(String id) {
        Note elemento = new Note(id);
        return find(elemento);
    }
    
    @Override
    public Note find(Note note) {
        List<Note> notes = findAll();
        int posicion = notes.indexOf(note);
        if (posicion < 0) {
            return new Note();
        }
        return notes.get(posicion);
    }
    
    @Override
    public List<Note> findAll() {
        lock.readLock().lock();
        try {
            return Collections.unmodifiableList(readAllInternal());
        } finally {
            lock.readLock().unlock();
        }
    }
    
    @Override
    public Note save(Note note) {
        lock.writeLock().lock();
        try {
            List<Note> notes = findAll();
            if (note.getId() == null || note.getId().isBlank()) {
                note.setId(UUID.randomUUID().toString());
            }
            notes.removeIf(n -> Objects.equals(n.getId(), note.getId()));
            notes.add(note);
            writeAllInternal(notes);
            return note;
        } finally {
            lock.writeLock().unlock();
        }
    }
    
    private void writeAllInternal(List<Note> items) {
        try {
            byte[] bytes = mapper.writerWithDefaultPrettyPrinter().writeValueAsBytes(items);
            Files.write(path, bytes,
            StandardOpenOption.CREATE,
            StandardOpenOption.TRUNCATE_EXISTING,
            StandardOpenOption.WRITE);
        } catch (IOException e) {
            throw new RuntimeException("Error escribiendo JSON", e);
        }
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
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
