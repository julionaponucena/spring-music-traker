package com.example.springteste.modules.musics.controllers;

import com.example.springteste.modules.musics.dtos.CreateMusicDTO;
import com.example.springteste.modules.musics.dtos.FindMusicDTO;
import com.example.springteste.modules.musics.dtos.ListMusicDTO;
import com.example.springteste.modules.musics.dtos.UpdateMusicDTO;
import com.example.springteste.modules.musics.services.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/musics")
public class MusicController {
    private final MusicService service;

    @GetMapping
    public List<ListMusicDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public FindMusicDTO findMusic(@PathVariable int id) {
        return service.findMusic(id);
    }

    @DeleteMapping("/{id}")
    public void deleteMusic(@PathVariable int id) {
        service.deleteMusic(id);
    }

    @PutMapping
    public void updateMusic(@RequestBody UpdateMusicDTO musicDTO) {
        service.updateMusic(musicDTO);
    }

    @PostMapping
    public void createMusic(@RequestBody CreateMusicDTO musicDTO) {
        service.createMusic(musicDTO);
    }
}
