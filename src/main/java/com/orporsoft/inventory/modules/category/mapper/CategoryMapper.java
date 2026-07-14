package com.orporsoft.inventory.modules.category.mapper;

import org.springframework.stereotype.Component;

import com.orporsoft.inventory.modules.category.dto.request.CategoryRequest;
import com.orporsoft.inventory.modules.category.dto.response.CategoryResponse;
import com.orporsoft.inventory.modules.category.entity.Category;

@Component
public class CategoryMapper {

    public Category toEntity(CategoryRequest request){

        Category entity=new Category();

        entity.setCode(request.getCode());
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setStatus("ACTIVE");

        return entity;
    }

    public CategoryResponse toResponse(Category entity){

        return CategoryResponse.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .description(entity.getDescription())
                .status(entity.getStatus())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();

    }

}
