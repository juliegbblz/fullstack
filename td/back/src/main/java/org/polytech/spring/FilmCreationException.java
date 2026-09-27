package org.polytech.spring;

public class FilmCreationException extends RuntimeException {
    public FilmCreationException() {
        super("Erreur lors de la création du film.");
    }    
}
