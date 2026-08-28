package com.example.springteste.modules.band.services;

import com.example.springteste.modules.band.converters.BandConverter;
import com.example.springteste.modules.band.dtos.CreateBandDTO;
import com.example.springteste.modules.band.dtos.FindBandDTO;
import com.example.springteste.modules.band.dtos.ListBandDTO;
import com.example.springteste.modules.band.dtos.UpdateBandDTO;
import com.example.springteste.modules.band.models.Band;
import com.example.springteste.modules.band.repositories.BandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BandService {
    private final BandConverter converter;
    private final BandRepository repository;

    public void create(CreateBandDTO createBandDTO) {
        final Band band = converter.fromCreateBandDTO(createBandDTO);

        this.repository.save(band);
    }

    public void update(UpdateBandDTO updateBandDTO) {
        final Band band = converter.fromUpdateBandDTO(updateBandDTO);

        this.repository.save(band);
    }

    public void delete(int id) {
        this.repository.deleteById(id);
    }

    public FindBandDTO find(int id) {
        final Band band = this.repository.findById(id).orElseThrow(() -> new RuntimeException("Band not found"));

        return converter.toFindBandDTO(band);
    }

    public List<ListBandDTO> findAll() {
        final List<Band> bands = this.repository.findAll();

        return bands.stream().map(converter::toListBandDTO).toList();
    }
}
