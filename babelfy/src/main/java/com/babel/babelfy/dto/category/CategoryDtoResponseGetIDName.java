package com.babel.babelfy.dto.category;

import com.babel.babelfy.model.Category;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDtoResponseGetIDName {

    private long id;
    private String name;

    public static CategoryDtoResponseGetIDName categoryToCategoryDto(Category category) {
        return CategoryDtoResponseGetIDName.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

}
