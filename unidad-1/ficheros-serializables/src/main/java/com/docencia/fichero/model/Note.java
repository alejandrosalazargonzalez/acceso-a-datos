package com.docencia.fichero.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Clase note que almacena informacion
 * @author alejandrosalazargonzalez
 * @version 1.0.0
 */
public class Note {

    @NotBlank
    private String id;

    @NotBlank @Size(max = 200)
    private String title;

    @NotBlank
    private String content;

    public Note(){

    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
