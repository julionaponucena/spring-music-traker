package com.example.springteste.modules.musictemperature.services;

import com.example.springteste.modules.musictemperature.converters.MusicTemperatureConverters;
import com.example.springteste.modules.musictemperature.dtos.CreateMusicTemperatureDTO;
import com.example.springteste.modules.musictemperature.dtos.FindMusicTemperatureDTO;
import com.example.springteste.modules.musictemperature.dtos.ListMusicTemperatureDTO;
import com.example.springteste.modules.musictemperature.dtos.UpdateMusicTemperatureDTO;
import com.example.springteste.modules.musictemperature.models.MusicTemperature;
import com.example.springteste.modules.musictemperature.repositories.MusicTemperatureRepository;
import com.example.springteste.modules.musics.repositories.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicTemperatureService {
    private final MusicTemperatureRepository repository;
    private final MusicTemperatureConverters converter;
    private final MusicRepository musicRepository;

    public void create(CreateMusicTemperatureDTO createMusicTemperatureDTO) {
        MusicTemperature musicTemperature = converter.fromCreateMusicTemperatureDTO(createMusicTemperatureDTO);

        repository.save(musicTemperature);
    }

    public void update(UpdateMusicTemperatureDTO dto) {
        MusicTemperature musicTemperature = this.repository.findById(dto.id()).orElseThrow();

        musicTemperature.setName(dto.name());

        repository.save(musicTemperature);
    }


    public void delete(int id) {
        if (musicRepository.existsByMusicTemperatureId(id)) {
            throw new RuntimeException("Cannot delete music temperature: there are musics associated with this temperature");
        }

        repository.deleteById(id);
    }

    public List<ListMusicTemperatureDTO> findAll() {
        return repository.findAll().stream().map(converter::toListMusicTemperatureDTO).toList();
    }

    public FindMusicTemperatureDTO findById(int id) {
        return converter.toFindMusicTemperatureDTO(this.repository.findById(id).orElseThrow());
    }
}
