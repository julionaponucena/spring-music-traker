package com.example.springteste.modules.categories.controllers;

import com.example.springteste.modules.categories.dto.CategoryDTO;
import com.example.springteste.modules.categories.dto.CreateCategoryDTO;
import com.example.springteste.modules.categories.dto.UpdateCategoryDTO;
import com.example.springteste.modules.categories.models.Category;
import com.example.springteste.modules.categories.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDTO> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public CategoryDTO findById(@PathVariable int id) {
        return categoryService.findById(id);
    }

    @PostMapping
    public Category save(@RequestBody CreateCategoryDTO dto) {
        return categoryService.create(dto);
    }

    @PutMapping
    public Category update(@RequestBody UpdateCategoryDTO dto) {
        return categoryService.update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        categoryService.delete(id);
    }
}
