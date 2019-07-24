package com.cesar.ejercicio.service;


import com.cesar.ejercicio.domain.Movie;
import com.cesar.ejercicio.exception.InvalidMovieException;
import com.cesar.ejercicio.exception.InvalidNameException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @Test
    public void searchByName_withExistingName_returnsMovieName() {
        String name = "Los Simuladores";
        Movie movie = movieService.searchByName(name);

        assertThat(movie).isNotNull();
        assertThat(movie.getName()).isEqualTo(name);
    }

    @Test
    public void searchByName_withNoneExistentName_returnsNull() {
        String name = "WalkingHere";
        Movie movie = movieService.searchByName(name);

        assertThat(movie).isNull();
    }

    @Test(expected = InvalidNameException.class)
    public void searchByName_withNameNull_throwsException() {

        movieService.searchByName(null);


    }

    @Test
    public void save_withValidMovie_saveMovie() {
        Movie movie = new Movie();
        movie.setCountry("Argentina");
        movie.setDirector("Richard Cuan");
        movie.setReleaseDate("12/10/2016");
        movie.setName("La Chorizada");

        Movie newMovie = movieService.save(movie);
        assertThat(newMovie).isNotNull();
        assertThat(newMovie.getName() == movie.getName() && newMovie.getReleaseDate() == movie.getReleaseDate()
                && newMovie.getDirector() == movie.getDirector() && newMovie.getCountry() == movie.getCountry()).isTrue();


    }

    @Test
    public void save_withInvalidMovie_returnsNull() {
        Movie movie = new Movie();

        Movie newMovie = movieService.save(movie);
        assertThat(newMovie).isNull();

    }

    @Test(expected = InvalidMovieException.class)
    public void save_withNullMovie_throwsException() {
        movieService.save(null);

    }

 @Test public void update_withExistingName_returnsMovie() {
 Movie movie = new Movie();
 movie.setName("Los Simuladores");
 movie.setCountry("Argentina");
 movie.setDirector("Un Tipo");
 movie.setReleaseDate("4 de abril");

 Movie newMovie = movieService.update(movie);

 assertThat(newMovie.getName() == movie.getName()).isTrue();


 }
}


