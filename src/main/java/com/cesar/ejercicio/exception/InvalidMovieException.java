package com.cesar.ejercicio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidMovieException extends RuntimeException {

    public InvalidMovieException(String mensaje) {
        super(mensaje);
    }

}
