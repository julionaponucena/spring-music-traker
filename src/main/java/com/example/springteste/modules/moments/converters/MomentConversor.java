package com.example.springteste.modules.moments.converters;

import com.example.springteste.modules.moments.dto.CreateMomentDTO;
import com.example.springteste.modules.moments.dto.MomentDTO;
import com.example.springteste.modules.moments.dto.UpdateMomentDTO;
import com.example.springteste.modules.moments.models.Moment;
import org.springframework.stereotype.Component;

@Component
public class MomentConversor {

    public Moment toEntity(MomentDTO dto) {
        return Moment.builder()
                .id(dto.id())
                .name(dto.name())
                .build();
    }

    public Moment toEntity(CreateMomentDTO dto) {
        return Moment.builder()
                .name(dto.name())
                .build();
    }

    public MomentDTO toDTO(Moment moment) {
        return new MomentDTO(moment.getId(), moment.getName());
    }

    public Moment toEntity(UpdateMomentDTO dto){
        return Moment.builder()
                .id(dto.id())
                .name(dto.name())
                .build();
    }
}
