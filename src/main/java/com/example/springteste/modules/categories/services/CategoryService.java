package com.example.springteste.modules.categories.services;

import com.example.springteste.modules.categories.dto.CategoryDTO;
import com.example.springteste.modules.categories.dto.CreateCategoryDTO;
import com.example.springteste.modules.categories.dto.UpdateCategoryDTO;
import com.example.springteste.modules.categories.models.Category;
import com.example.springteste.modules.moments.models.Moment;
import com.example.springteste.modules.categories.repositories.CategoryRepository;
import com.example.springteste.modules.moments.repositories.MomentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final MomentRepository momentRepository;

    public List<CategoryDTO> findAll() {
        final List<Category> categories = categoryRepository.findAll(Sort.by(Sort.Direction.DESC,"value"));

        return categories.stream()
            .map(convertToCategoryDTO())
            .toList();
    }

    private static Function<Category, CategoryDTO> convertToCategoryDTO() {
        return category -> new CategoryDTO(category.getId(),
                category.getName(),
                category.getValue(),
                category.getMoments() != null
                    ? category.getMoments().stream()
                        .map(moment -> new CategoryDTO.MomentDTO(moment.getId(), moment.getName())).toList()
                    : List.of());
    }

    public CategoryDTO findById(int id) {
        final Category category = categoryRepository.findById(id).orElseThrow();

//        List<Moment> moments = category.getMoments();

        return convertToDTO(category);
    }

    private static CategoryDTO convertToDTO(Category category) {
        final List<CategoryDTO.MomentDTO>
                momentDTOS =category.getMoments().stream().map(CategoryService::convertToMomentDTO).toList();

        return new CategoryDTO(category.getId(), category.getName(),category.getValue(), momentDTOS);
    }

    private static CategoryDTO.MomentDTO convertToMomentDTO(Moment moment){
        return new CategoryDTO.MomentDTO(moment.getId(), moment.getName());
    }

    public Category create(CreateCategoryDTO dto) {
        Category category = new Category();
        category.setName(dto.getName());
        category.setValue(dto.getValue());

        if (dto.getMomentIds() != null && dto.getMomentIds().length > 0) {
            List<Moment> moments = momentRepository.findAllById(
                Arrays.stream(dto.getMomentIds()).boxed().toList()
            );
            category.setMoments(moments);
        }

        return categoryRepository.save(category);
    }

    public Category update(UpdateCategoryDTO dto) {
        Category category = categoryRepository.findById(dto.getId()).orElseThrow();
        category.setName(dto.getName());
        category.setValue(dto.getValue());

        if (dto.getMomentIds() != null) {
            List<Moment> moments = momentRepository.findAllById(
                Arrays.stream(dto.getMomentIds()).boxed().toList()
            );
            category.setMoments(moments);
        } else {
            category.setMoments(null);
        }

        return categoryRepository.save(category);
    }

    public void delete(int id) {
        categoryRepository.deleteById(id);
    }
}
