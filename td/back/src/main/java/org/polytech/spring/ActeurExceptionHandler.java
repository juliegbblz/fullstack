package org.polytech.spring;
import java.net.URI;
import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ActeurExceptionHandler {

    @ExceptionHandler(ActeurNotFoundException.class)
    public ProblemDetail handleActeurNotFound(ActeurNotFoundException ex) {
        ProblemDetail pb = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        pb.setTitle("Acteur non trouvé");
        pb.setType(URI.create("https://localhost:8080/errors/acteurs"));
        pb.setProperty("timestamp", Instant.now());
        return pb;
    }

    @ExceptionHandler(ActeurCreationException.class)
    public ProblemDetail handleActeurCreation(ActeurCreationException ex) {
        ProblemDetail pb = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
        pb.setTitle("Nom de l'acteur manquant");
        pb.setType(URI.create("https://localhost:8080/errors/acteurs"));
        pb.setProperty("timestamp", Instant.now());
        return pb;
    }

}