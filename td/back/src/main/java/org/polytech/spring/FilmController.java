package org.polytech.spring;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;

@RestController
public class FilmController {

    private final FilmService service;

    public FilmController(FilmService s) {
        service = s;
    }

    @GetMapping("/films/{id}")
    public FilmDto findById(@PathVariable("id") long id) {
        return service.findById(id);
    }

    @GetMapping("/films/{id}/acteurs")
    public List<ActeurDto> findActeursByFilmId(@PathVariable("id") long id) {
        return service.findActeursByFilmId(id);
    }
    @Transactional
    @PostMapping("/films/{id}/acteurs/{acteurId}")
    public ResponseEntity<Void> addActeurInFilm(
            @PathVariable("id") long id,
            @PathVariable("acteurId") long acteurId) {
        service.addActeurInFilm(id, acteurId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/films/{id}/acteurs/{acteurId}")
    public ResponseEntity<Void> removeActeur(
            @PathVariable("id") long id,
            @PathVariable("acteurId") long acteurId) {
        //service.removeActeur(id, acteurId);
        return ResponseEntity.noContent().build();
    }
}