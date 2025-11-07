package com.docencia.repository;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import com.docencia.hotel.model.Hotel;

@SpringBootTest
@ActiveProfiles("test")
class NoteJpaRepositoryTest {

    @Autowired
    private INoteRepository noteRepository;

    private Hotel baseNote; 
    
    @BeforeEach
    @Transactional
    void beforeEach() {
        Hotel n = new Hotel();
        n.setName("Nota base");
        n.setAddress("contenido base");

        baseNote = noteRepository.save(n);

        assertThat(baseNote.getId()).isNotNull();
    }

    @Test
    @Transactional
    void createReadFindByTitleTest() {
        String id = baseNote.getId();

        Hotel leida = noteRepository.findById(id);
        assertThat(leida).isNotNull();
        assertThat(leida.getName()).isEqualTo("Nota base");
        assertThat(leida.getAddress()).isEqualTo("contenido base");

        Hotel buscadaPorTitulo = noteRepository.find(leida);
        assertThat(buscadaPorTitulo).isNotNull();
        assertThat(buscadaPorTitulo.getId()).isEqualTo(id);
    }

    @Test
    @Transactional
    void updateContentTest() {
        String id = baseNote.getId();

        baseNote.setAddress("contenido modificado");
        Hotel actualizada = noteRepository.save(baseNote);

        assertThat(actualizada.getAddress())
                .isEqualTo("contenido modificado");

        Hotel reread = noteRepository.findById(id);
        assertThat(reread.getAddress())
                .isEqualTo("contenido modificado");
    }

    @Test
    @Transactional
    void findByIdTest() {
        String id = baseNote.getId();

        boolean exists = noteRepository.exists(id);

        assertThat(exists).isTrue();
    }

    @Test
    @Transactional
    void deleteNoteTest() {
        String id = baseNote.getId();

        boolean borrada = noteRepository.delete(id);

        assertThat(borrada).isTrue();
        assertThat(noteRepository.exists(id)).isFalse();
        assertThat(noteRepository.findById(id)).isNull();
    }
}
