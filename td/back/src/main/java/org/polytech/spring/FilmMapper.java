package org.polytech.spring;

import java.util.stream.Collectors;

public final class FilmMapper {

    public static FilmDto toDto(Film f){
        return new FilmDto(
            f.getId(),
            f.getTitre(),
            f.getRealisateur(),
            f.getDateSortie(),
            f.getGenre(),
            f.getActeurs().stream()
                .map(ActeurMapper::toDto)
                .collect(Collectors.toSet())
        );
}

    public static Film toEntity (FilmCreationDto d){
        Film f = new Film();
        f.setTitre(d.titre());
        f.setRealisateur(d.realisateur());
        f.setDateSortie(d.dateSortie());
        f.setGenre(d.genre());
        return f;


    }
    
}
