package com.babel.babelfy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Category {

    private String name;
    @Id
    private long id;
    
    public String getName() {
        return name;
    }
    public void setNombre(String name) {
        this.name = name;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Category(String name, long id) {
        this.name = name;
        this.id = id;
    }
    public Category() {
    }

    
}
