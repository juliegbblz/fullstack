package org.polytech.spring;

import java.time.LocalDate;

public record FilmDto(
    Long id,
    String titre,
    String realisateur,
    LocalDate date_sortie,
    Genre genre
) {}
