package com.babel.babelfy.dto.category;

import java.util.ArrayList;
import java.util.List;

import com.babel.babelfy.dto.song.SongDtoResponseToCategory;
import com.babel.babelfy.model.Category;
import com.babel.babelfy.model.Song;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDtoResponseDetails {

    private String name;
    private List<SongDtoResponseToCategory> songs;
    

    public static CategoryDtoResponseDetails categoryToCategoryDTO(Category c) {
        List<SongDtoResponseToCategory> listDto = new ArrayList<>();
        for (Song song : c.getSongs()) {
            listDto.add(SongDtoResponseToCategory.songToCSongDTO(song));
        }
        return CategoryDtoResponseDetails.builder()
                    .name(c.getName())
                    .songs(listDto)
                    .build();
    }

}
