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
        return Song.builder()
                .name(songDto.getName())
                .duration(songDto.getDuration())
                .artistName(songDto.getArtistName())
                .albumName(songDto.getAlbumName())
                .releaseDate(songDto.getReleaseDate())
                .build();
    }
    public static SongDtoResponseGetAll songToSongDTO(Song s) {
        return SongDtoResponseGetAll.builder()
                .id(s.getId())
                .name(s.getName())
                .build();
    }
}
