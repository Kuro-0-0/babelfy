package com.babel.babelfy.dto.song;

import com.babel.babelfy.model.Artist;
import com.babel.babelfy.model.Song;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class SongDtoResponseDetails {


    private String name;
    private int duration;
    private List<String> artistList;
    private List<Long> artistIDlist;
    private String albumName;
    private LocalDate releaseDate;
    private String categoryName;
    private long categoryID;

    public static SongDtoResponseDetails songToCSongDTO(Song s) {
        String categoryName;
        long categoryID;
        List<String> artistList = new ArrayList<>();
        List<Long> artistIDlist = new ArrayList<>();

        if (s.getCategory() != null) {
            categoryName = s.getCategory().getName();
            categoryID = s.getCategory().getId();
        } else {
            categoryName = "None";
            categoryID = -1;
        }

        for (Artist a : s.getArtists()) {
            artistList.add(a.getName());
            artistIDlist.add(a.getId());
        }

        return SongDtoResponseDetails.builder()
                .name(s.getName())
                .duration(s.getDuration())
                .artistList(artistList)
                .artistIDlist(artistIDlist)
                .albumName(s.getAlbumName())
                .releaseDate(s.getReleaseDate())
                .categoryName(categoryName)
                .categoryID(categoryID)
                .build();
    }
}