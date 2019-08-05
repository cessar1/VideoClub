package com.cesar.ejercicio.controller.Rest;

import com.cesar.ejercicio.domain.Movie;
import com.cesar.ejercicio.exception.InvalidMovieException;
import com.cesar.ejercicio.exception.MovieNotFoundException;
import com.cesar.ejercicio.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/movies")
public class MovieRestController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/{name}")
    public Movie searchByName(@PathVariable String name){
        Movie movie = movieService.searchByName(name);
        if( movie == null){
            throw new MovieNotFoundException("There is not any movie with that name");
        }
        return movie;

    }
    @PostMapping
    public Movie save(@RequestBody Movie newMovie){
        Movie movie = movieService.save(newMovie);
        if(newMovie == null){
            throw new InvalidMovieException("Invalid Movie");
        }
        return movie;
    }

    @PutMapping("/{id}")
    public Movie update(@PathVariable Long id, @RequestBody Movie movie ){

        if(id == null || movie == null){
            throw new InvalidMovieException("Invalid Movie");
        }
        return movieService.update(id, movie);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        movieService.deleteById(id);
    }


}
