package com.orporsoft.inventory.modules.category.controller;

import java.time.LocalDateTime;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orporsoft.inventory.common.response.ApiResponse;
import com.orporsoft.inventory.modules.category.dto.request.CategoryRequest;
import com.orporsoft.inventory.modules.category.dto.response.CategoryResponse;
import com.orporsoft.inventory.modules.category.service.CategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @PostMapping
    public ApiResponse<CategoryResponse> create(
            @Valid @RequestBody CategoryRequest request){

        return ApiResponse.<CategoryResponse>builder()
                .success(true)
                .message("Category created successfully")
                .data(service.create(request))
                .timestamp(LocalDateTime.now())
                .build();

    }

    @GetMapping
    public ApiResponse<Page<CategoryResponse>> search(

            @RequestParam(defaultValue="") String keyword,

            @RequestParam(required=false) String status,

            @ParameterObject
            @PageableDefault(size=10,sort="name")
            Pageable pageable){

        return ApiResponse.<Page<CategoryResponse>>builder()
                .success(true)
                .message("Success")
                .data(service.search(keyword,status,pageable))
                .timestamp(LocalDateTime.now())
                .build();

    }

    @GetMapping("/{id}")
    public ApiResponse<CategoryResponse> findById(
            @PathVariable Long id){

        return ApiResponse.<CategoryResponse>builder()
                .success(true)
                .message("Success")
                .data(service.findById(id))
                .timestamp(LocalDateTime.now())
                .build();

    }

    @PutMapping("/{id}")
    public ApiResponse<CategoryResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody CategoryRequest request){

        return ApiResponse.<CategoryResponse>builder()
                .success(true)
                .message("Category updated successfully")
                .data(service.update(id,request))
                .timestamp(LocalDateTime.now())
                .build();

    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(
            @PathVariable Long id){

        service.delete(id);

        return ApiResponse.<Void>builder()
                .success(true)
                .message("Category deleted successfully")
                .timestamp(LocalDateTime.now())
                .build();

    }

}
