package org.polytech.spring;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class PatientDataBase implements PatientStore {
    @PostConstruct 
    public void init() {
        System.out.println("ouverture connexion");
    }
    
    @PreDestroy
    public void close() {
        System.out.println("fermeture connexion");
    }
}
