package com.babel.babelfy.dto.category;

import com.babel.babelfy.model.Category;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoryDtoRequestCreate {

    private String name;

    // Helpers

    public static Category categoryDTOToCategory (CategoryDtoRequestCreate categoryDTO){
        return Category.builder()
                .name(categoryDTO.getName())
                .build();
    }

}
