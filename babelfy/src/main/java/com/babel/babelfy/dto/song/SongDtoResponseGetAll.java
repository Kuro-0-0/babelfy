package com.babel.babelfy.dto.song;

import com.babel.babelfy.model.Song;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SongDtoResponseGetAll {

    private long id;
    private String name;
    private String color;

    public static SongDtoResponseGetAll songToSongDTO(Song s) {

        return SongDtoResponseGetAll.builder()
                .id(s.getId())
                .name(s.getName())
                .color(s.getColor())
                .build();
    }
}
