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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FilmController {

    private final FilmService service;

    public FilmController(FilmService s) {
        service = s;
    }

    @GetMapping("/films")
    public List<Film> getAllFilm(@RequestParam(required = false) String titre) {
        return service.getAllFilm();
    }

    @GetMapping("/films/{id}")
    public Film filmParId(@PathVariable long id) {
        return service.filmParId(id);
    }

    @PostMapping("/films")
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
    }
}