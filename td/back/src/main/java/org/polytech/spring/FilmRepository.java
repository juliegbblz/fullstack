package org.polytech.spring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository 
public interface FilmRepository extends JpaRepository<Film,Long>{

    /* List<Film> films = new ArrayList<>(List.of(
        new Film((long) 1, "Inception", "Christopher Nolan", LocalDate.of(2010, 7, 21), Genre.ACTION),
        new Film((long) 2, "Interstellar", "Christopher Nolan", LocalDate.of(2014, 11, 5), Genre.ACTION),
        new Film((long) 3, "Parasite", "Bong Joon-ho", LocalDate.of(2019, 5, 30), Genre.DRAME)
    )); */

    List<Film> findByTitre(String titre);    

    List<Film> findByRealisateur(String realisateur);

    List<Film> findByDateSortie(LocalDate date_sortie);

    List<Film> findByGenre(Genre genre);

    List<Film> findByActeursId(Long acteurId);

    @Query("select f from Film f join f.acteurs a where a.id = :acteurId")
    List<Film> findFilmsByActeurId(@Param("acteurId") Long acteurId);

}
