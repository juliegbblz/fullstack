package org.polytech.spring;

public class ActeurCreationException extends RuntimeException {
    public ActeurCreationException() {
        super("Erreur lors de la création de l'acteur.");
    }    
}
