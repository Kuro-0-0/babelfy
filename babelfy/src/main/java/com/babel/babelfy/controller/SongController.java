package com.babel.babelfy.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;

import com.babel.babelfy.dto.song.SongDTOResponseGetAll;
import com.babel.babelfy.dto.song.SongDtoRequestCreate;
import com.babel.babelfy.service.SongService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/songs")
@RestController
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;

    @GetMapping
    public ResponseEntity<List<SongDTOResponseGetAll>> getAll() {
        return songService.getAll();
    }

    @PostMapping("")
    public String create(@RequestBody SongDtoRequestCreate sDTO) {
        return songService.add(sDTO);
    }

}
