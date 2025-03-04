package com.babel.babelfy.model;

import java.util.List;

import jakarta.persistence.*;

import lombok.*;


@Entity
@Data
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String name;
}
