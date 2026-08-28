package com.example.springteste.modules.categories.dto;

import java.util.List;

public record CategoryDTO(int id, String name, int value, List<MomentDTO> moments) {
    public record MomentDTO(int id, String name) {}
}
