package com.babel.babelfy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Song {

    @Id
    private long id;
    private String name;

}
