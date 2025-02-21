package com.babel.babelfy.controller;

import com.babel.babelfy.dto.song.SongDTOResponseGetAll;
import com.babel.babelfy.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/songs")
@RestController
@RequiredArgsConstructor

public class SongController {

    private final SongService songService;

    @GetMapping
    public ResponseEntity<List<SongDTOResponseGetAll>> getAll() {
        return songService.getAll();
    }

}
