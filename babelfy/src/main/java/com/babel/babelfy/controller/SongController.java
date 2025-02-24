package com.babel.babelfy.controller;

import java.util.List;

import com.babel.babelfy.dto.song.SongDTORequestUpdate;
import lombok.RequiredArgsConstructor;

import com.babel.babelfy.dto.song.SongDTOResponseDetails;
import com.babel.babelfy.dto.song.SongDTOResponseGetAll;
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
    public ResponseEntity<List<SongDTOResponseGetAll>> getAll() {
        return songService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SongDTOResponseDetails> getDetails(@PathVariable long id){return songService.getDetails(id);}



    @PostMapping("")
    public String create(@RequestBody SongDtoRequestCreate sDTO) {
        return songService.add(sDTO);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody SongDTORequestUpdate sDTO) {return songService.update(sDTO);}

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id){
        return songService.delete(id);
    }

}
