package com.example.springteste.modules.musics.models;

import com.example.springteste.modules.band.models.Band;
import com.example.springteste.modules.moments.models.Moment;
import com.example.springteste.modules.musictemperature.models.MusicTemperature;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "musics")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "band_id")
    private Band band;

    @ManyToOne
    @JoinColumn(name = "music_temperature_id")
    private MusicTemperature musicTemperature;

    @ManyToMany
    @JoinTable(
        name = "musics_moments",
        joinColumns = @JoinColumn(name = "music_id"),
        inverseJoinColumns = @JoinColumn(name = "moment_id")
    )
    private List<Moment> moments;
}
