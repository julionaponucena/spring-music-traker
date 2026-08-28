package com.example.springteste.modules.musictemperature.repositories;

import com.example.springteste.modules.musictemperature.models.MusicTemperature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicTemperatureRepository extends JpaRepository<MusicTemperature, Integer> {
}
