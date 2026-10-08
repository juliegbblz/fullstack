package org.polytech.spring;

public class ActeurNotFoundException extends RuntimeException {
    public ActeurNotFoundException() {
        super("Acteur introuvable");
    }
}