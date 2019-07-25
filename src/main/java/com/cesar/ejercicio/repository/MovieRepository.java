package com.cesar.ejercicio.repository;

import com.cesar.ejercicio.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;



public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findByName(String name);


}
