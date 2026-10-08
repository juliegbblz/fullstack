package org.polytech.spring;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.transaction.Transactional;

@RestController
public class FilmController {

    private final FilmService service;

    public FilmController(FilmService s) {
        service = s;
    }

    @GetMapping ("/films")
    public List<FilmDto> findAll() {
        return service.findAll();
    }
    
    /* @PostMapping("/films")
    public ResponseEntity<Film> ajouteFilm(@RequestBody Film film) {
        service.ajouteFilm(film);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(film.getId()).toUri();
        return ResponseEntity.created(location).body(film);
    }

    @PutMapping("/films/{id}")
    public Film majFilm(@PathVariable long id, @RequestBody Film nouveauFilm) {
        return service.majFilm(id, nouveauFilm);
    }

    @DeleteMapping("/films/{id}")
    public ResponseEntity<Void> suppFilm(@PathVariable long id) {
        service.suppFilm(id);
        return ResponseEntity.noContent().build();
    } */

    @GetMapping("/films/{id}")
    public FilmDto findById(@PathVariable("id") long id) {
        return service.findById(id);
    }

    @GetMapping("/films/{id}/acteurs")
    public List<ActeurDto> findActeursByFilmId(@PathVariable("id") long id) {
        return service.findActeursByFilmId(id);
    }

    /* @Transactional
    @PostMapping("/films/{id}/acteurs/{acteurId}")
    public ResponseEntity<Void> addActeurInFilm(
            @PathVariable("id") long id,
            @PathVariable("acteurId") long acteurId) {
        service.addActeurInFilm(id, acteurId);
        return ResponseEntity.noContent().build();
    } */

    @DeleteMapping("/films/{id}/acteurs/{acteurId}")
    public ResponseEntity<Void> removeActeur(
            @PathVariable("id") long id,
            @PathVariable("acteurId") long acteurId) {
        //service.removeActeur(id, acteurId);
        return ResponseEntity.noContent().build();
    }
}