package com.babel.babelfy.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Song {
     @Id
    private long id;
    
    private String name;
    private int duration;
    private String artistName;
    private String albumName;
    private LocalDate releaseDate;
}
