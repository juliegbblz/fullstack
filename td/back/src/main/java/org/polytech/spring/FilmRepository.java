package org.polytech.spring;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository 
public class FilmRepository {
    List<Film> films = new ArrayList<>(List.of(
        new Film((long) 1, "Inception", "Christopher Nolan", LocalDate.of(2010, 7, 21), Genre.ACTION),
        new Film((long) 2, "Interstellar", "Christopher Nolan", LocalDate.of(2014, 11, 5), Genre.ACTION),
        new Film((long) 3, "Parasite", "Bong Joon-ho", LocalDate.of(2019, 5, 30), Genre.DRAME)
    ));

public List<Film> getAllFilm(){
    return films;

}

public Film filmParId(long id){
    Film film = null;
    for (int i = 0; i < films.size(); i++) {
        if(films.get(i).getId()==id){
            film = films.get(i);
        }
    }
    return film;
}

public void ajouteFilm(Film film){
    long dernierId;
    if (films.isEmpty()) {
        dernierId = 0;
    } else {
        dernierId = films.get(films.size() - 1).getId();
    }
    film.setId(dernierId + 1);
    films.add(film);
}

public void majFilm(long id, Film nouveauFilm){
    for (Film film : films) {
        if (film.getId() == id) {
            film.setTitre(nouveauFilm.getTitre());
            film.setRealisateur(nouveauFilm.getRealisateur());
            film.setDateSortie(nouveauFilm.getDateSortie());
            film.setGenre(nouveauFilm.getGenre());
            return;
        }
    }
}

public void suppFilm(long id){
    for (int i = 0; i < films.size(); i++) {
        if(films.get(i).getId()==id){
            films.remove(i);
        }
    }
}

}
