package com.example.springteste.modules.musictemperature.converters;

import com.example.springteste.modules.musictemperature.dtos.CreateMusicTemperatureDTO;
import com.example.springteste.modules.musictemperature.dtos.FindMusicTemperatureDTO;
import com.example.springteste.modules.musictemperature.dtos.ListMusicTemperatureDTO;
import com.example.springteste.modules.musictemperature.models.MusicTemperature;
import org.springframework.stereotype.Component;

@Component
public class MusicTemperatureConverters {

    public MusicTemperature  fromCreateMusicTemperatureDTO(CreateMusicTemperatureDTO createMusicTemperatureDTO) {
        return MusicTemperature.builder().name(createMusicTemperatureDTO.name()).build();
    }

    public ListMusicTemperatureDTO toListMusicTemperatureDTO(MusicTemperature musicTemperature) {
        return new ListMusicTemperatureDTO(musicTemperature.getId(), musicTemperature.getName());
    }

    public FindMusicTemperatureDTO toFindMusicTemperatureDTO(MusicTemperature musicTemperature) {
        return new FindMusicTemperatureDTO(musicTemperature.getId(), musicTemperature.getName());
    }


}
