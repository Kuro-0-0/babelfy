package com.babel.babelfy.dto.song;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.babel.babelfy.model.Artist;
import com.babel.babelfy.model.Song;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SongDtoResponseToCategory {

    private long id;
    private String name;
    private int duration;
    private List<String> artistList;
    private String albumName;
    private LocalDate releaseDate;

    public static SongDtoResponseToCategory songToCSongDTO(Song s) {

        List<String> artistList = new ArrayList<>();

        for (Artist a : s.getArtists()) {
            artistList.add(a.getName());
        }

        return SongDtoResponseToCategory.builder()
                .id(s.getId())
                .name(s.getName())
                .duration(s.getDuration())
                .artistList(artistList)
                .albumName(s.getAlbumName())
                .releaseDate(s.getReleaseDate())
                .build();
    }
}