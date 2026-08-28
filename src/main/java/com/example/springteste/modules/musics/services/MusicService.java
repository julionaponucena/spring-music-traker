package com.example.springteste.modules.musics.services;

import com.example.springteste.modules.band.models.Band;
import com.example.springteste.modules.band.repositories.BandRepository;
import com.example.springteste.modules.moments.models.Moment;
import com.example.springteste.modules.moments.repositories.MomentRepository;
import com.example.springteste.modules.musics.converters.MusicConversor;
import com.example.springteste.modules.musics.dtos.CreateMusicDTO;
import com.example.springteste.modules.musics.dtos.FindMusicDTO;
import com.example.springteste.modules.musics.dtos.ListMusicDTO;
import com.example.springteste.modules.musics.dtos.UpdateMusicDTO;
import com.example.springteste.modules.musics.models.Music;
import com.example.springteste.modules.musics.repositories.MusicRepository;
import com.example.springteste.modules.musictemperature.models.MusicTemperature;
import com.example.springteste.modules.musictemperature.repositories.MusicTemperatureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicService {
    private final MusicRepository musicRepository;
    private final MusicConversor musicConversor;
    private final BandRepository bandRepository;
    private final MomentRepository momentRepository;
    private final MusicTemperatureRepository musicTemperatureRepository;

    public void createMusic(CreateMusicDTO musicDTO) {
        final Music music = musicConversor.fromCreateMusicDTO(musicDTO);

        final Band band = getBand(musicDTO.band().id());


        final List<Moment> moments = getMoment(musicDTO.momentIds());

        music.setBand(band);
        music.setMoments(moments);

        if(musicDTO.musicTemperature() != null) {
            music.setMusicTemperature(getMusicTemperature(musicDTO.musicTemperature().id()));
        }

        musicRepository.save(music);
    }

    private Band getBand(int id) {
        return bandRepository.findById(id)
                .orElseThrow();
    }

    private MusicTemperature getMusicTemperature(int id) {
        return musicTemperatureRepository.findById(id)
                .orElseThrow();
    }

    private List<Moment> getMoment(List<Integer> ids) {
        return momentRepository.findAllById(ids);
    }

    public void updateMusic(UpdateMusicDTO musicDTO) {
        final Music music = musicRepository.findById(musicDTO.id())
                .orElseThrow();

        final Band band = getBand(musicDTO.band().id());

        music.setBand(band);
        music.setMoments(getMoment(musicDTO.momentIds()));

        if(musicDTO.musicTemperature() != null) {
            music.setMusicTemperature(getMusicTemperature(musicDTO.musicTemperature().id()));
        }else{
            music.setMusicTemperature(null);
        }

        musicRepository.save(music);
    }

    public FindMusicDTO findMusic(int id) {
        final Music music = musicRepository.findById(id)
                .orElseThrow();

        return this.musicConversor.toFindMusicDTO(music);
    }

    public void deleteMusic(int id) {
        musicRepository.deleteById(id);
    }

    public List<ListMusicDTO> findAll() {
        final List<Music> musics = musicRepository.findAll();

        return musics.stream().map(musicConversor::toListMusicDTO).toList();
    }
}
