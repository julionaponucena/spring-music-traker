package com.example.springteste.modules.moments.controllers;

import com.example.springteste.modules.moments.dto.CreateMomentDTO;
import com.example.springteste.modules.moments.dto.MomentDTO;
import com.example.springteste.modules.moments.dto.UpdateMomentDTO;
import com.example.springteste.modules.moments.services.MomentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moments")
@RequiredArgsConstructor
public class MomentController {

    private final MomentService service;

    @GetMapping
    public List<MomentDTO> findAll() {
        return this.service.findAll();
    }

    @GetMapping("/{id}")
    public MomentDTO findById(@PathVariable int id) {
        return this.service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        this.service.deleteById(id);
    }

    @PostMapping
    public void create(@RequestBody CreateMomentDTO moment){
        this.service.create(moment);
    }

    @PutMapping
    public void update(@RequestBody UpdateMomentDTO moment){
        this.service.update(moment);
    }

}
