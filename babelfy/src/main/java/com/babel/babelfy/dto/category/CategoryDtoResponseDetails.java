package com.babel.babelfy.dto.category;

import com.babel.babelfy.model.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDtoResponseDetails {

    private String name;
    

    public static CategoryDtoResponseDetails categoryToCategoryDTO(Category c) {
        return new CategoryDtoResponseDetails(c.getName());
    }

}
