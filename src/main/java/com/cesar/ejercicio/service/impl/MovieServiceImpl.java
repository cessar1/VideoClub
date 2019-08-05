package com.cesar.ejercicio.service.impl;

import com.cesar.ejercicio.domain.Movie;
import com.cesar.ejercicio.exception.InvalidMovieException;
import com.cesar.ejercicio.exception.InvalidNameException;
import com.cesar.ejercicio.repository.MovieRepository;
import com.cesar.ejercicio.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie searchByName(String name) {
        if (name == null) {
            throw new InvalidNameException("Invalid name");
        }
        return movieRepository.findByName(name);

    }

    @Override
    public Movie save(Movie movie) {
        if (movie == null) {
            throw new InvalidMovieException("Pelicula invalida");
        } else if (movie != null && movie.getName() != null && movie.getCountry() != null &&
                movie.getDirector() != null && movie.getReleaseDate() != null) {
            return movieRepository.save(movie);
        } else {
            return null;
        }
    }

    @Override
    public Movie update(Long id, Movie movie) {

        Movie movieToModify = movieRepository.findById(id).orElse(null);

        if (movieToModify == null || movie.getName() == null || movie.getCountry() == null ||
                movie.getDirector() == null || movie.getReleaseDate() == null ){
            return null;
        }

        movieToModify.setName(movie.getName());
        movieToModify.setReleaseDate(movie.getReleaseDate());
        movieToModify.setCountry(movie.getCountry());
        movieToModify.setDirector(movie.getDirector());

        return movieRepository.save(movieToModify);
    }

    @Override
    public void deleteById(Long id) {

        movieRepository.deleteById(id);
    }

    @Override
    public List<Movie> findInPagesSortedByName(int pageNumber) {
        Pageable page = PageRequest.of(pageNumber,3, Sort.by("name").ascending());
        return movieRepository.findAll(page).getContent();
    }


}
