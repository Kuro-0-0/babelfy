package com.babel.babelfy.dto;

//@Data
public class CategoryDTO {

    private String name;
    public String getName() {
        return name;
    }
    public void setNombre(String name) {
        this.name = name;
    }
    public CategoryDTO(String name) {
        this.name = name;
    }
    public CategoryDTO() {
    }

    @Override
    public String toString() {
        return "CategoryDTO [ name=" + name + "]";
    }

    
}
