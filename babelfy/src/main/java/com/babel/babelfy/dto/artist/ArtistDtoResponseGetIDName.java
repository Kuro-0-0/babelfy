package com.babel.babelfy.dto.artist;

import com.babel.babelfy.dto.category.CategoryDtoResponseGetIDName;
import com.babel.babelfy.model.Artist;
import com.babel.babelfy.model.Category;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ArtistDtoResponseGetIDName {

    private long id;
    private String name;

    public static ArtistDtoResponseGetIDName artistToArtistDTO(Artist artist) {
        return ArtistDtoResponseGetIDName.builder()
                .id(artist.getId())
                .name(artist.getName())
                .build();
    }
}
