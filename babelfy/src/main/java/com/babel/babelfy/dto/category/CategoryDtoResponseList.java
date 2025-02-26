package com.babel.babelfy.dto.category;

import java.util.List;

import com.babel.babelfy.model.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDtoResponseList {

    private long id;
    private String name;
    private String color;

    public static CategoryDtoResponseList categoryToCategoryDTO(Category c) {
        return new CategoryDtoResponseList(c.getId(), c.getName(), c.getColor());
    }

}
