package com.babel.babelfy.dto.category;

import com.babel.babelfy.model.Category;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDtoResponseGetValueSelector {

    private long id;
    private String name;

    public static CategoryDtoResponseGetValueSelector categoryToCategoryDto(Category category) {
        return CategoryDtoResponseGetValueSelector.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

}
