package com.example.springteste.modules.musics.dtos;

import com.example.springteste.modules.musics.dtos.shared.BandDTO;
import com.example.springteste.modules.musics.dtos.shared.MomentDTO;
import com.example.springteste.modules.musics.dtos.shared.MusicTemperatureDTO;

import java.util.List;

public record FindMusicDTO(int id, String name, BandDTO band, List<MomentDTO> moments,
                           MusicTemperatureDTO musicTemperature) {
}
