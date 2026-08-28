package com.example.springteste.modules.band.repositories;

import com.example.springteste.modules.band.models.Band;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BandRepository extends JpaRepository<Band, Integer> {
}
