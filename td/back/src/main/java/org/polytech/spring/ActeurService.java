package org.polytech.spring;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ActeurService {

    private final ActeurRepository repository;

    public ActeurService(ActeurRepository r) {
        this.repository = r;
    }

    public List<ActeurDto> findAll(){
        return repository.findAll().stream().map(ActeurMapper::toDto).toList();
    }

    public ActeurDto findById(long id){
        Acteur acteur = repository.findById(id);
        if (acteur == null) throw new ActeurNotFoundException();
        return ActeurMapper.toDto(acteur);
    }
    public ActeurDto addActeur(ActeurCreationDto body) {
        Acteur acteur = new Acteur();
        if (body.nom() == null || body.nom().isBlank()) {
            throw new ActeurCreationException();
        }
        acteur.setNom(body.nom());
        repository.save(acteur);
        return ActeurMapper.toDto(acteur);
    }
    public ActeurDto updateActeur(long id, ActeurDto body) {
        Acteur acteur = repository.findById(id);
        if (acteur == null) throw new ActeurNotFoundException();
        acteur.setNom(body.nom());
        repository.save(acteur);
        return ActeurMapper.toDto(acteur);
    }
}
