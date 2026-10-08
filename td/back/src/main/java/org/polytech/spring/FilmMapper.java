package org.polytech.spring;

public final class FilmMapper {

    public static FilmDto toDto(Film f){
        return new FilmDto(
            f.getId(),
            f.getTitre(),
            f.getRealisateur(),
            f.getDateSortie(),
            f.getGenre());
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
