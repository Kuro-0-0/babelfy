package com.babel.babelfy.controller;

import com.babel.babelfy.dto.artist.*;
import com.babel.babelfy.dto.category.CategoryDtoRequestUpdate;
import com.babel.babelfy.dto.category.CategoryDtoResponseGetIDName;
import com.babel.babelfy.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/artists")
public class ArtistController {

    private final ArtistService artistService;

    @GetMapping("")
    public ResponseEntity<List<ArtistDtoResponseGetAll>> listAll(@RequestParam(required = false) String name) {
        return artistService.divideGet(name);
    }

    @PutMapping("")
    public ResponseEntity<String> change(@RequestBody ArtistDtoRequestUpdate request) {
        return artistService.modify(request);
    }

    @GetMapping("/{id}")
    public ArtistDtoResponseDetails show(@PathVariable long id) {
        return artistService.showDetails(id);
    }

    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody ArtistDtoRequestCreate aDTO) {
        return artistService.add(aDTO);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        return artistService.delete(id);
    }

    @GetMapping("/names")
    public ResponseEntity<List<ArtistDtoResponseGetIDName>> getIDName() {
        return artistService.getIDName();
    }


}