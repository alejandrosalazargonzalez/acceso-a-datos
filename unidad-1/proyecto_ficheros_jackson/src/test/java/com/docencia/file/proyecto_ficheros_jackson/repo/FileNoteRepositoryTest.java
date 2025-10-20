package com.docencia.file.proyecto_ficheros_jackson.repo;

import org.junit.jupiter.api.Test;

public class FileNoteRepositoryTest {
    FileNoteRepository fileNoteRepository;

    @Test
    void createFileTest(){
        fileNoteRepository = new FileNoteRepository();
    }
}
