package com.babel.babelfy.dto.artist;

import com.babel.babelfy.model.Artist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArtistDtoResponseGetAll {

    private long id;
    private String name;
    private String color;

    public static ArtistDtoResponseGetAll artistToArtistDTO(Artist a) {
        return ArtistDtoResponseGetAll.builder()
                .id(a.getId())
                .name(a.getName())
                .color(a.getColor())
                .build();
    }
}