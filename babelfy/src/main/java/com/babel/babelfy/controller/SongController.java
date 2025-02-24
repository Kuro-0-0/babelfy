package com.babel.babelfy.controller;

import java.util.List;

import com.babel.babelfy.dto.song.*;
import lombok.RequiredArgsConstructor;

import com.babel.babelfy.service.SongService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/songs")
@RestController
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;

    @GetMapping
    public ResponseEntity<List<SongDTOResponseGetAll>> getAll() {
        return songService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SongDTOResponseDetails> getDetails(@PathVariable long id){return songService.getDetails(id);}

    @PutMapping
    public ResponseEntity<String> updateSong(@RequestBody SongDTORequestUpdate sDTO) {return songService.update(sDTO);}

    @PostMapping("")
    public String create(@RequestBody SongDtoRequestCreate sDTO) {
        return songService.add(sDTO);
    }

}
