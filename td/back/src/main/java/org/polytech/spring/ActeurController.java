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
    public ActeurDto findActeursById(@PathVariable("id") long id) {
        return service.findById(id);
    }

    @PostMapping("/acteurs") //creation
    public ResponseEntity<ActeurDto> addActeur(@RequestBody ActeurCreationDto body) {
        ActeurDto acteurDto = service.addActeur(body);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(acteurDto.id()).toUri();
        return ResponseEntity.created(uri).body(acteurDto);
    }

    @PutMapping("/acteurs/{id}") //modif
    public ResponseEntity<ActeurDto> updateActeur(@PathVariable long id, @RequestBody ActeurDto body) {
        service.updateActeur(id, body);
        return ResponseEntity.noContent().build();
    }

    /* @DeleteMapping("/films/{id}/acteurs/{acteurId}")
    public ResponseEntity<Void> removeActeur(
            @PathVariable long id,
            @PathVariable long acteurId) {
        //service.removeActeur(id, acteurId);
        return ResponseEntity.noContent().build();
    } */
}