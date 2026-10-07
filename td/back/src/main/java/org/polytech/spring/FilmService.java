package org.polytech.spring;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class FilmService {

    private final FilmRepository repository;
    private final ActeurRepository acteurRepository;

    public FilmService(FilmRepository r,ActeurRepository a) {
        this.repository = r;
        this.acteurRepository = a;
    }

    public List<FilmDto> findByTitre(String titre){
        String searchTitre = ObjectUtils.isEmpty(titre) ? "%" : titre;
        return repository.findByTitre(searchTitre).stream().map(FilmMapper::toDto).toList();
    }

    public List<FilmDto> findById(long id){
        long searchId = ObjectUtils.isEmpty(id) ? 0 : id;
        return repository.findById(searchId).stream().map(FilmMapper::toDto).toList();
    }

    public List<Acteur> findActeursById(long id){
        return acteurRepository.findActeursByFilmId(id);
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
