package com.babel.babelfy.dto;

import com.babel.babelfy.model.Category;

public class CategoryDtoResponseDetails {

    private String name;
    
        public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryDtoResponseDetails() {
    }

    public CategoryDtoResponseDetails(String name) {
        this.name = name;
    }

    public static CategoryDtoResponseDetails categoryToCategoryDTO(Category c){
        return new CategoryDtoResponseDetails(c.getName());


    }





}
