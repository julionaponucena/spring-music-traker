package com.example.springteste.modules.moments.services;

import com.example.springteste.modules.moments.converters.MomentConversor;
import com.example.springteste.modules.moments.dto.CreateMomentDTO;
import com.example.springteste.modules.moments.dto.MomentDTO;
import com.example.springteste.modules.moments.dto.UpdateMomentDTO;
import com.example.springteste.modules.moments.models.Moment;
import com.example.springteste.modules.moments.repositories.MomentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MomentService {

    private final MomentRepository repository;
    private final MomentConversor conversor;

    public List<MomentDTO> findAll() {
        final List<Moment> moments = this.repository.findAll();

        return moments.stream().map(conversor::toDTO).toList();
    }

    public MomentDTO findById(int id) {
        return this.repository.findById(id)
                .map(conversor::toDTO)
                .orElse(null);
    }

    public void deleteById(int id) {
        this.repository.deleteById(id);
    }

    public void create(CreateMomentDTO dto) {
        final Moment moment = conversor.toEntity(dto);
        this.repository.save(moment);
    }

    public void update(UpdateMomentDTO dto) {
        final Moment moment = this.conversor.toEntity(dto);

        this.repository.save(moment);
    }

}
