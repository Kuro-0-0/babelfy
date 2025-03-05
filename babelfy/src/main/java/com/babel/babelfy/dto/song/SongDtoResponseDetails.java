package com.babel.babelfy.dto.song;

import com.babel.babelfy.model.Artist;
import com.babel.babelfy.model.Song;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class SongDtoResponseDetails {


    private String name;
    private int duration;
    private List<Artist> artistList;
    private String albumName;
    private LocalDate releaseDate;
    private String categoryName;
    private long categoryID;

    public static SongDtoResponseDetails songToCSongDTO(Song s) {
        String categoryName;
        long categoryID;

        if (s.getCategory() != null) {
            categoryName = s.getCategory().getName();
            categoryID = s.getCategory().getId();
        } else {
            categoryName = "None";
            categoryID = -1;
        }
        return SongDtoResponseDetails.builder()
                .name(s.getName())
                .duration(s.getDuration())
                .artistList(s.getArtists())
                .albumName(s.getAlbumName())
                .releaseDate(s.getReleaseDate())
                .categoryName(categoryName)
                .categoryID(categoryID)
                .build();
    }
}