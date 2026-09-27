package org.polytech.spring;

public class FilmNotFoundException extends RuntimeException {
    public FilmNotFoundException() {
        super("Film introuvable");
    }
}
