package com.orporsoft.inventory.modules.category.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.orporsoft.inventory.exception.DuplicateResourceException;
import com.orporsoft.inventory.exception.ResourceNotFoundException;
import com.orporsoft.inventory.modules.category.dto.request.CategoryRequest;
import com.orporsoft.inventory.modules.category.dto.response.CategoryResponse;
import com.orporsoft.inventory.modules.category.entity.Category;
import com.orporsoft.inventory.modules.category.mapper.CategoryMapper;
import com.orporsoft.inventory.modules.category.repository.CategoryRepository;
import com.orporsoft.inventory.modules.category.specification.CategorySpecification;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    @Override
    public CategoryResponse create(CategoryRequest request) {

        if (repository.existsByCode(request.getCode())) {
            throw new DuplicateResourceException("Category code already exists");
        }

        Category entity = mapper.toEntity(request);

        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public CategoryResponse update(Long id,
                                   CategoryRequest request) {

        Category category = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found"));

        if (!category.getCode().equals(request.getCode())
                && repository.existsByCode(request.getCode())) {

            throw new DuplicateResourceException("Category code already exists");
        }

        category.setCode(request.getCode());
        category.setName(request.getName());
        category.setDescription(request.getDescription());

        return mapper.toResponse(repository.save(category));
    }

    @Override
    public CategoryResponse findById(Long id) {

        Category category = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found"));

        return mapper.toResponse(category);
    }

    @Override
    public void delete(Long id) {

        Category category = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found"));

        repository.delete(category);

    }

    @Override
    public Page<CategoryResponse> search(String keyword,
                                          String status,
                                          Pageable pageable) {

        Specification<Category> specification =
                Specification.where(
                        CategorySpecification.keyword(keyword))
                        .and(
                                CategorySpecification.status(status));

        return repository.findAll(specification, pageable)
                .map(mapper::toResponse);
    }

}
