package com.cesar.ejercicio.domain;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Movie{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private String releaseDate;
    private String director;


}
