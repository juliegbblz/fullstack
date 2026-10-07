package org.polytech.spring;

import java.time.LocalDate;

public record FilmCreationDto(
    String titre,
    String realisateur,
    LocalDate date_sortie,
    Genre genre
) {}
