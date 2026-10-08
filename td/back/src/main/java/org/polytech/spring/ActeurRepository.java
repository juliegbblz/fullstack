package org.polytech.spring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ActeurRepository extends JpaRepository<Acteur, Long> {

    Acteur findById(long id);

    @Query ("select a from Acteur a join a.films f where f.id = :filmId")
    java.util.List<Acteur> findActeursByFilmId(long filmId);

}