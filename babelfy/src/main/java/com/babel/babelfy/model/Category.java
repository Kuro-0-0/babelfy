package com.babel.babelfy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Category {

    private String name;
    @Id
    private long id;
    
    public Category(String name, long id) {
        this.name = name;
        this.id = id;
    }
    public Category() {
    }

    
}
