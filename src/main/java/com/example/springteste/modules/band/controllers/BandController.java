package com.example.springteste.modules.band.controllers;

import com.example.springteste.modules.band.dtos.CreateBandDTO;
import com.example.springteste.modules.band.dtos.FindBandDTO;
import com.example.springteste.modules.band.dtos.ListBandDTO;
import com.example.springteste.modules.band.dtos.UpdateBandDTO;
import com.example.springteste.modules.band.services.BandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bands")
public class BandController {
    private final BandService service;

    @PostMapping
    public void create(@RequestBody CreateBandDTO createBandDTO) {
        service.create(createBandDTO);
    }

    @PutMapping
    public void update(@RequestBody UpdateBandDTO updateBandDTO) {
        service.update(updateBandDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @GetMapping
    public List<ListBandDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public FindBandDTO find(@PathVariable int id) {
        return service.find(id);
    }
}
