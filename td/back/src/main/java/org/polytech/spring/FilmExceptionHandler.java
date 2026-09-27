package org.polytech.spring;
import java.net.URI;
import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FilmExceptionHandler {

    @ExceptionHandler(FilmNotFoundException.class)
    public ProblemDetail handleFilmNotFound(FilmNotFoundException ex) {
        ProblemDetail pb = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        pb.setTitle("Film non trouvé");
        pb.setType(URI.create("https://localhost:8080/errors/films"));
        pb.setProperty("timestamp", Instant.now());
        return pb;
    }
    
    @ExceptionHandler(FilmCreationException.class)
    public ProblemDetail handleFilmCreation(FilmCreationException ex){
        ProblemDetail pb = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
        pb.setTitle("Certains champs du film vides");
        pb.setType(URI.create("https://localhost:8080/errors/films"));
        pb.setProperty("timestamp", Instant.now());
        return pb;

    }

}