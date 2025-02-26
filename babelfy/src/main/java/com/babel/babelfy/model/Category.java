package com.babel.babelfy.model;

import java.util.List;

import jakarta.persistence.*;

import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String name;
    private List<Integer> color;

    @OneToMany(mappedBy = "category")
    private List<Song> songs;

}
