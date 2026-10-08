package org.polytech.spring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository 
public interface FilmRepository extends JpaRepository<Film,Long>{

    Film findById(long id);

    List<Film> findAll();

    

    List<Film> findByActeursId(Long acteurId);

    @Query("select f from Film f join f.acteurs a where a.id = :acteurId")
    List<Film> findFilmsByActeurId(@Param("acteurId") Long acteurId);

    @Query("select a from Acteur a join a.films f where f.id = :filmId")
    List<Acteur> findActeursByFilmId(@Param("filmId") Long filmId);

}
