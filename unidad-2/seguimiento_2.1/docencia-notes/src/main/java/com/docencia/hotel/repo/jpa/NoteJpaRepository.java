package com.docencia.hotel.repo.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.docencia.hotel.model.Hotel;
import com.docencia.hotel.repo.INoteRepository;

@Repository
public class NoteJpaRepository implements INoteRepository {

    private final INoteJpaRepository repository;

    public NoteJpaRepository(INoteJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean exists(String id) {
        return repository.existsById(id);
    }

    @Override
    public Hotel findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Hotel find(Hotel example) {
        return repository.findFirstByTitle(example.getName()).orElse(null);
    }

    @Override
    public List<Hotel> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Hotel save(Hotel note) {
        if (note.getId() == null || note.getId().isBlank()) {
            note.setId(UUID.randomUUID().toString());
        }
        return repository.save(note);
    }

    @Override
    @Transactional
    public boolean delete(String id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}
