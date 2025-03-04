package com.babel.babelfy.controller;

import com.babel.babelfy.dto.artist.ArtistDtoRequestCreate;
import com.babel.babelfy.dto.category.CategoryDtoRequestCreate;
import com.babel.babelfy.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/artists")
public class ArtistController {

    private final ArtistService artistService;

    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody ArtistDtoRequestCreate aDTO) {
        return artistService.add(aDTO);
    }

}