package org.polytech.spring;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ActeurRepository extends JpaRepository<Acteur, Long> {


    List<Acteur> findByFilmsId(Long filmId);

    @Query("select a from Acteur a join a.films f where f.id = :filmId")
    List<Acteur> findActeursByFilmId(@Param("filmId") Long filmId);
}