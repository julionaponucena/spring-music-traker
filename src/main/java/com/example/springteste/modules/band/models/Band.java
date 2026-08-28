package com.example.springteste.modules.band.models;

import com.example.springteste.modules.musics.models.Music;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "bands")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class Band {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @OneToMany(mappedBy = "band")
    private List<Music> musics;
}
