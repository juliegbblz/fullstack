package org.polytech.spring;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FilmService {

    private final FilmRepository repository;

    public FilmService(FilmRepository r){
        this.repository = r;
    }

    public  List<Film> getAllFilm(){
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
    }
    
}
