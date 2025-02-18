package com.babel.babelfy.dto.category;

import com.babel.babelfy.model.Category;

public class CategoryDtoResponseList {

    private long id;
    private String name;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public CategoryDtoResponseList(long id, String name) {
        this.id = id;
        this.name = name;
    }
    public CategoryDtoResponseList() {
    }

    public static CategoryDtoResponseList categoryToCategoryDTO(Category c){
        return new CategoryDtoResponseList(c.getId(), c.getName());


    }



}
