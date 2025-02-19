package com.babel.babelfy.dto.category;

import com.babel.babelfy.model.Category;
import lombok.Data;

@Data
public class CategoryDtoRequestChange {

    private long id;
    private String name;

    public CategoryDtoRequestChange(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryDtoRequestChange() {
    }

    public static Category categoryDTOToCategory(CategoryDtoRequestChange c){
        return Category.builder()
                .id(c.getId())
                .name(c.getName())
                .build();
    }

    @Override
    public String toString() {
        return "CategoryDtoRequestChange [id=" + id + ", name=" + name + "]";
    }





}
