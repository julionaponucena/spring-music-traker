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

    @ManyToMany
    @JoinTable(
        name = "moments_categories",
        joinColumns = @JoinColumn(name = "moment_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    @ManyToMany
    @JoinTable(
        name = "moments_musics",
        joinColumns = @JoinColumn(name = "moment_id"),
        inverseJoinColumns = @JoinColumn(name = "music_id")
    )
    private  List<Music> musics;
}
