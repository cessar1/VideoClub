package com.cesar.ejercicio.service.impl;

import com.cesar.ejercicio.domain.Movie;
import com.cesar.ejercicio.exception.InvalidMovieException;
import com.cesar.ejercicio.exception.InvalidNameException;
import com.cesar.ejercicio.repository.MovieRepository;
import com.cesar.ejercicio.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie searchByName(String name) {
        if(name == null){
            throw new InvalidNameException("Invalid name");
        }
        return movieRepository.findByName(name);

    }

    @Override
    public Movie save(Movie movie) {
        if(movie == null){
            throw new InvalidMovieException("Pelicula invalida");
        }

        else if (movie != null && movie.getName() != null && movie.getCountry() != null &&
                movie.getDirector() != null && movie.getReleaseDate() != null) {
            return movieRepository.save(movie);
        } else {
            return null;
        }
    }

    @Override
    public Movie update(Movie movie) {
        if (movie.getName() != null) {
            movieRepository.save(movie);
        }
        return null;
    }

}
