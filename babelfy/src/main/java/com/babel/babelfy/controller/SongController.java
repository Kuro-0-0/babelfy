package com.babel.babelfy.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import com.babel.babelfy.dto.song.*;
import com.babel.babelfy.service.SongService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{id}")
    public ResponseEntity<SongDTOResponseDetails> getDetails(@PathVariable long id){return songService.getDetails(id);}



    @PostMapping("")
    public String create(@RequestBody SongDtoRequestCreate sDTO) {
        return songService.add(sDTO);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id){
        return songService.delete(id);
    }
}
