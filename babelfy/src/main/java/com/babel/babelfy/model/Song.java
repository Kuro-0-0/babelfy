package com.babel.babelfy.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int duration;
    private String albumName;
    private LocalDate releaseDate;
    private String color;

    @ManyToOne
    private Category category;

    @ManyToMany
    private List<Artist> artists;

    public Song(String name, int duration, List<Artist> artistList, String albumName, LocalDate releaseDate, Category category) {
        this.name = name;
        this.duration = duration;
        this.artists = artistList;
        this.albumName = albumName;
        this.releaseDate = releaseDate;
        this.category = category;
    }

}
