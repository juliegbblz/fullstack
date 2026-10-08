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

    public List<ActeurDto> findById(long id){
        return repository.findById(id).stream().map(ActeurMapper::toDto).toList();
    }
    
}
