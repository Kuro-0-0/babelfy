package com.babel.babelfy.dto.category;

import com.babel.babelfy.model.Category;

public class CategoryDtoRequestChange {

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
    public CategoryDtoRequestChange(long id, String name) {
        this.id = id;
        this.name = name;
    }
    public CategoryDtoRequestChange() {
    }

    public static Category categoryDTOToCategory(CategoryDtoRequestChange c){
        return new Category(c.getId(), c.getName());
    }
    @Override
    public String toString() {
        return "CategoryDtoRequestChange [id=" + id + ", name=" + name + "]";
    }





}
