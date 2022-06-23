package com.guibue.workshopmongo.resources.exceptions;

import com.guibue.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    public static final String NOT_FOUND = "Não encontrado";

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        StandardError error = new StandardError(Instant.now(), HttpStatus.NOT_FOUND, NOT_FOUND, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(error.getStatus()).body(error);
    }
}
