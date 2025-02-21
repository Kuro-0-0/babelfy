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

    public static Song SongDtoToSong(SongDtoRequestCreate songDto){
        return new Song(songDto.getName(),songDto.getDuration(),
        songDto.artistName, songDto.getAlbumName(), songDto.getReleaseDate());
    }



}
