package com.example.springteste.modules.musics.dtos;

import com.example.springteste.modules.musics.dtos.shared.BandRefDTO;
import com.example.springteste.shared.dtos.RelationDTO;

import java.util.List;

public record CreateMusicDTO(String name, BandRefDTO band, List<Integer> momentIds, RelationDTO musicTemperature) {
}
