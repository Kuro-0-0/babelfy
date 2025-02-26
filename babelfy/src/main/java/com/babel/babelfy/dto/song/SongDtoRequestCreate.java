package com.babel.babelfy.dto.song;

import java.time.LocalDate;

import com.babel.babelfy.model.Song;

import lombok.Data;

@Data
public class SongDtoRequestCreate {

    private String name;
    private int duration;
    private String artistName;
    private String albumName;
    private LocalDate releaseDate;
    private long idCategory;

    
    public static SongDtoResponseGetAll songToSongDTO(Song s) {
        return SongDtoResponseGetAll.builder()
                .id(s.getId())
                .name(s.getName())
                .build();
    }
}
