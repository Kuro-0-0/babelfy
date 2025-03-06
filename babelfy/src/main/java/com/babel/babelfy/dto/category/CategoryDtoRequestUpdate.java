package com.babel.babelfy.dto.category;

import com.babel.babelfy.model.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDtoRequestUpdate {

    private long id;
    private String name;

    public static Category categoryDTOToCategory(CategoryDtoRequestUpdate c) {
        return Category.builder()
                .id(c.getId())
                .name(c.getName())
                .build();
    }

}
