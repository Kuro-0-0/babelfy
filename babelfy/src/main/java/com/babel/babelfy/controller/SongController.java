package com.babel.babelfy.controller;

import java.util.List;

import com.babel.babelfy.dto.song.SongDtoRequestUpdate;
import lombok.RequiredArgsConstructor;

import com.babel.babelfy.dto.song.SongDtoResponseDetails;
import com.babel.babelfy.dto.song.SongDtoResponseGetAll;
import com.babel.babelfy.dto.song.SongDtoRequestCreate;
import com.babel.babelfy.service.SongService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/songs")
@RestController
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;

    @GetMapping
    public ResponseEntity<List<SongDtoResponseGetAll>> getAll(@RequestParam(required = false) String name) {
        return songService.divideGet(name);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SongDtoResponseDetails> getDetails(@PathVariable long id) {
        return songService.getDetails(id);
    }

    @PostMapping("")
    public String create(@RequestBody SongDtoRequestCreate sDTO) {
        return songService.add(sDTO);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody SongDtoRequestUpdate sDTO) {
        return songService.update(sDTO);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        return songService.delete(id);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable long id) {
        return songService.deleteCategory(id);
    }

}
