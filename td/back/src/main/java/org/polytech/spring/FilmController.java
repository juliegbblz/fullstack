package org.polytech.spring;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilmController {

    private final FilmService service;

    public FilmController(FilmService s) {
        service = s;
    }

    @GetMapping("/films/{id}")
    public List<FilmDto> findById(@PathVariable("id") long id) {
        return service.findById(id);
    }

    @GetMapping("/films/{id}/acteurs")
    public List<Acteur> findActeursById(@PathVariable("id") long id) {
        return service.findActeursById(id);
    }

    @PostMapping("/films/{id}/acteurs/{acteurId}")
    public ResponseEntity<Void> addActeur(
            @PathVariable("id") long id,
            @PathVariable("acteurId") long acteurId) {
        //service.addActeur(id, acteurId);
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