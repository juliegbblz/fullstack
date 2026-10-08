package org.polytech.spring;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import jakarta.transaction.Transactional;

@Service
public class FilmService {

    private final FilmRepository repository;
    private final ActeurRepository acteurRepository;

    public FilmService(FilmRepository r, ActeurRepository a) {
        this.repository = r;
        this.acteurRepository = a;

    }


    public FilmDto findById(long id){
        Film film = repository.findById(id);
        if (film == null) throw new FilmNotFoundException();
        return FilmMapper.toDto(film);
    }

    public List<ActeurDto> findActeursByFilmId(long id){
        long searchId = ObjectUtils.isEmpty(id) ? 0 : id;
        return repository.findActeursByFilmId(searchId).stream().map(ActeurMapper::toDto).toList();
    }

    @Transactional
    public void addActeurInFilm(long id, long idActeur) {
        Film film = repository.findById(id);
        Acteur newActeur = acteurRepository.findById(idActeur);
        film.getActeurs().add(newActeur);
    }

    /* public  List<Film> getAllFilm(){
        return repository.getAllFilm() ;
    }

    public Film filmParId(long id){
        Film film = repository.filmParId(id);
        if (film == null) throw new FilmNotFoundException();
        return film;
    }

    public void ajouteFilm(Film film){
        if(film.getTitre()==null || film.getDateSortie()==null || film.getRealisateur()==null || film.getGenre()==null)
        {
            throw new FilmCreationException();
        }
        repository.ajouteFilm(film);
    }

    public Film majFilm(long id, Film nouveauFilm){
        repository.majFilm(id, nouveauFilm);
        return filmParId(id);
    }

    public void suppFilm(long id){
        repository.suppFilm(id);
    } */
    
}
