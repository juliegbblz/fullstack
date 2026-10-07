package org.polytech.spring;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity 
@Table(name = "acteur")
public class Acteur {

    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    Long id;

    @Column (nullable = false,length = 200)
    String nom;

    @ManyToMany(mappedBy = "acteurs")
    private Set<Film> films = new HashSet<>();

    public Acteur() {}

    public Acteur(Long id, String nom){
        this.id = id;
        this.nom = nom;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNom(){
        return nom;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }
}
