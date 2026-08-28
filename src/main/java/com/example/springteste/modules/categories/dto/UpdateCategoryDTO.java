package com.example.springteste.modules.categories.dto;

import lombok.Data;

@Data
public class UpdateCategoryDTO {
    private int id;
    private String name;
    private Integer value;
    private int[] momentIds;
}
