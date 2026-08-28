package com.example.springteste.modules.band.converters;

import com.example.springteste.modules.band.dtos.CreateBandDTO;
import com.example.springteste.modules.band.dtos.FindBandDTO;
import com.example.springteste.modules.band.dtos.ListBandDTO;
import com.example.springteste.modules.band.dtos.UpdateBandDTO;
import com.example.springteste.modules.band.models.Band;
import org.springframework.stereotype.Component;

@Component
public class BandConverter {
    public Band fromCreateBandDTO(CreateBandDTO createBandDTO) {
        return Band.builder().name(createBandDTO.name()).build();
    }

    public Band fromUpdateBandDTO(UpdateBandDTO updateBandDTO) {
        return Band.builder()
                .name(updateBandDTO.name())
                .id(updateBandDTO.id())
                .build();
    }

    public FindBandDTO toFindBandDTO(Band band) {
        return new FindBandDTO(band.getId(), band.getName());
    }

    public ListBandDTO toListBandDTO(Band band) {
        return new ListBandDTO(band.getId(), band.getName());
    }
}
