package com.example.springteste.modules.moments.models;

import com.example.springteste.modules.categories.models.Category;
import com.example.springteste.modules.musics.models.Music;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Table(name = "moments")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Moment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(mappedBy = "moments")
    private List<Category> categories;

    @ManyToMany(mappedBy = "moments")
    private List<Music> musics;
}
