package com.babel.babelfy.dto.artist;

import com.babel.babelfy.model.Artist;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ArtistDtoResponseGetValueSelector {

    private long id;
    private String name;

    public static ArtistDtoResponseGetValueSelector artistToArtistDTO(Artist artist) {
        return ArtistDtoResponseGetValueSelector.builder()
                .id(artist.getId())
                .name(artist.getName())
                .build();
    }
}
