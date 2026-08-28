package com.example.springteste.modules.categories.models;

import com.example.springteste.modules.moments.models.Moment;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Entity
@Table(name = "categories")
@EqualsAndHashCode(of = "id")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Integer value;

    @ManyToMany
    @JoinTable(
            name = "moments_categories",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "moment_id")
    )
    private List<Moment> moments;
}
