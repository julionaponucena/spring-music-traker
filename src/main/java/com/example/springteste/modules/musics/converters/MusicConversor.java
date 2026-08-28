package com.example.springteste.modules.musics.converters;

import com.example.springteste.modules.band.models.Band;
import com.example.springteste.modules.moments.models.Moment;
import com.example.springteste.modules.musics.dtos.CreateMusicDTO;
import com.example.springteste.modules.musics.dtos.FindMusicDTO;
import com.example.springteste.modules.musics.dtos.ListMusicDTO;
import com.example.springteste.modules.musics.dtos.UpdateMusicDTO;
import com.example.springteste.modules.musics.dtos.shared.BandDTO;
import com.example.springteste.modules.musics.dtos.shared.MomentDTO;
import com.example.springteste.modules.musics.dtos.shared.MusicTemperatureDTO;
import com.example.springteste.modules.musics.models.Music;
import com.example.springteste.modules.musictemperature.models.MusicTemperature;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MusicConversor {
    public Music fromCreateMusicDTO(CreateMusicDTO musicDTO) {
        return Music.builder()
                .name(musicDTO.name())
                .build();
    }

    public ListMusicDTO toListMusicDTO(Music music){
        return new ListMusicDTO(
                music.getId(),
                music.getName(),
                toBandDTO(music.getBand()),
                mapMoments(music.getMoments()),
                toMusicTemperatureDTO(music.getMusicTemperature())
        );
    }

    private static MusicTemperatureDTO toMusicTemperatureDTO(MusicTemperature musicTemperature){
        if (musicTemperature == null) {
            return null;
        }
        return new MusicTemperatureDTO(musicTemperature.getId(),musicTemperature.getName());
    }

    public FindMusicDTO toFindMusicDTO(Music music){
        return new FindMusicDTO(
                music.getId(),
                music.getName(),
                toBandDTO(music.getBand()),
                mapMoments(music.getMoments()),
                toMusicTemperatureDTO(music.getMusicTemperature())
        );
    }

    private static BandDTO toBandDTO(Band band){
        if (band == null) {
            return null;
        }
        return new BandDTO(band.getId(), band.getName());
    }

    private static List<Integer> toMomentIdList(List<Moment> moments){
        return moments.stream().map(Moment::getId).toList();
    }

    private static List<MomentDTO> mapMoments(List<Moment> moments){
        return moments.stream().map(MusicConversor::toMomentDTO).toList();
    }

    private static MomentDTO toMomentDTO(Moment moment){
        return new MomentDTO(moment.getId(), moment.getName());
    }


    public Music fromUpdateMusicDTO(UpdateMusicDTO musicDTO){
        return Music.builder()
                .id(musicDTO.id())
                .name(musicDTO.name())
                .build();
    }
}
