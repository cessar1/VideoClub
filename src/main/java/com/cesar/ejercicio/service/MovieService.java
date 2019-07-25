package com.cesar.ejercicio.service;

import com.cesar.ejercicio.domain.Movie;
import com.cesar.ejercicio.exception.InvalidMovieException;

public interface MovieService {
    Movie searchByName(String name);
    Movie save(Movie movie) throws InvalidMovieException;
    Movie update(Long id,Movie movie);

}
