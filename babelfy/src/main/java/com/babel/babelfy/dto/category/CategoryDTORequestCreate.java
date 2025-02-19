package com.babel.babelfy.dto.category;

import com.babel.babelfy.model.Category;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoryDTORequestCreate {

    private String name;

    // Helpers

    public static Category categoryDTOToCategory (CategoryDTORequestCreate categoryDTO){
        return Category.builder()
                .name(categoryDTO.getName())
                .build();
    }

}
