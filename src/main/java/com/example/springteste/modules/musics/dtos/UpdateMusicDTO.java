package com.example.springteste.modules.musics.dtos;

import com.example.springteste.modules.musics.dtos.shared.BandRefDTO;
import com.example.springteste.modules.musics.dtos.shared.MomentDTO;
import com.example.springteste.shared.dtos.RelationDTO;

import java.util.List;

public record UpdateMusicDTO(int id, String name, BandRefDTO band, List<Integer> momentIds, RelationDTO musicTemperature) {
}
