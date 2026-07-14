package com.orporsoft.inventory.modules.category.service;

import com.orporsoft.inventory.modules.category.dto.request.CategoryRequest;
import com.orporsoft.inventory.modules.category.dto.response.CategoryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {

    CategoryResponse create(CategoryRequest request);

    CategoryResponse update(Long id, CategoryRequest request);

    CategoryResponse findById(Long id);

    Page<CategoryResponse> search(
            String keyword,
            String status,
            Pageable pageable);

    void delete(Long id);

}