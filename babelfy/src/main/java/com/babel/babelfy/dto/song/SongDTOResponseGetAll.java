package com.babel.babelfy.dto.song;

import com.babel.babelfy.model.Song;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SongDTOResponseGetAll {

    private long id;
    private String name;

    public static SongDTOResponseGetAll songToSongDTO(Song s) {
        return SongDTOResponseGetAll.builder()
                .id(s.getId())
                .name(s.getName())
                .build();
    }
}
