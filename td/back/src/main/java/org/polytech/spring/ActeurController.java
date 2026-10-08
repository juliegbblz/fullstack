package org.polytech.spring;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActeurController {

    private final ActeurService service;

    public ActeurController(ActeurService s) {
        service = s;
    }

    @GetMapping("/acteurs")
    public List<ActeurDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/acteurs/{id}")
    public List<ActeurDto> findActeursById(@PathVariable long id) {
        return service.findById(id);
    }

    @PostMapping("/acteurs") //creation
    public ResponseEntity<Void> addActeur(
            @PathVariable long id,
            @PathVariable long acteurId) {
        //service.addActeur(id, acteurId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/films/{id}/acteurs/{acteurId}")
    public ResponseEntity<Void> removeActeur(
            @PathVariable long id,
            @PathVariable long acteurId) {
        //service.removeActeur(id, acteurId);
        return ResponseEntity.noContent().build();
    }
}