package com.babel.babelfy.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int duration;
    private String artistName;
    private String albumName;
    private LocalDate releaseDate;

    public Song(String name, int duration, String artistName, String albumName, LocalDate releaseDate) {
        this.name = name;
        this.duration = duration;
        this.artistName = artistName;
        this.albumName = albumName;
        this.releaseDate = releaseDate;
    }
}
