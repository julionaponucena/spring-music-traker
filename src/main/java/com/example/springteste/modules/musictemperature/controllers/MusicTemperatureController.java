package com.example.springteste.modules.musictemperature.controllers;

import com.example.springteste.modules.musictemperature.dtos.CreateMusicTemperatureDTO;
import com.example.springteste.modules.musictemperature.dtos.FindMusicTemperatureDTO;
import com.example.springteste.modules.musictemperature.dtos.ListMusicTemperatureDTO;
import com.example.springteste.modules.musictemperature.dtos.UpdateMusicTemperatureDTO;
import com.example.springteste.modules.musictemperature.services.MusicTemperatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/music-temperatures")
@RequiredArgsConstructor
public class MusicTemperatureController {
    private final MusicTemperatureService service;

    @PostMapping
    public void create(@RequestBody CreateMusicTemperatureDTO dto) {
        service.create(dto);
    }

    @PutMapping
    public void update(@RequestBody UpdateMusicTemperatureDTO dto) {
        service.update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @GetMapping
    public List<ListMusicTemperatureDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public FindMusicTemperatureDTO findById(@PathVariable int id) {
        return service.findById(id);
    }
}
