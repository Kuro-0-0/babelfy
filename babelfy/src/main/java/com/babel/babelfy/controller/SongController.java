package com.babel.babelfy.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.babel.babelfy.dto.song.SongDtoRequestCreate;
import com.babel.babelfy.service.SongService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/songs")
@RestController
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;


    @PostMapping("")
    public String create(@RequestBody SongDtoRequestCreate sDTO) {
        return songService.add(sDTO);
    }

}
