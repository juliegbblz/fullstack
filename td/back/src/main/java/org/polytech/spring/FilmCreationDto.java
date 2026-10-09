package org.polytech.spring;

import java.time.LocalDate;

public record FilmCreationDto(
    String titre,
    String realisateur,
    //@JsonFormat (pattern = "dd/MM/yyyy" )
    LocalDate dateSortie,
    Genre genre
) {}
