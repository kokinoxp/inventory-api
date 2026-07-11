package com.orporsoft.inventory.controller;

import com.orporsoft.inventory.common.ApiResponse;
import com.orporsoft.inventory.dto.request.ProductRequest;
import com.orporsoft.inventory.dto.response.ProductResponse;
import com.orporsoft.inventory.security.JwtService;
import com.orporsoft.inventory.service.interfaces.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

        private final ProductService service;

        @PostMapping
        public ApiResponse<ProductResponse> create(
                        @Valid @RequestBody ProductRequest request) {

                ProductResponse response = service.create(request);

                return ApiResponse.<ProductResponse>builder()
                                .success(true)
                                .message("Product created successfully")
                                .data(response)
                                .timestamp(LocalDateTime.now())
                                .build();

        }

        @GetMapping
        public ApiResponse<List<ProductResponse>> findAll() {

                return ApiResponse.<List<ProductResponse>>builder()
                                .success(true)
                                .message("Success")
                                .data(service.findAll())
                                .timestamp(LocalDateTime.now())
                                .build();

        }

        @GetMapping("/{id}")
        public ApiResponse<ProductResponse> findById(
                        @PathVariable Long id) {

                return ApiResponse.<ProductResponse>builder()
                                .success(true)
                                .message("Success")
                                .data(service.findById(id))
                                .timestamp(LocalDateTime.now())
                                .build();

        }

        @PutMapping("/{id}")
        public ApiResponse<ProductResponse> update(
                        @PathVariable Long id,
                        @Valid @RequestBody ProductRequest request) {

                return ApiResponse.<ProductResponse>builder()
                                .success(true)
                                .message("Product updated successfully")
                                .data(service.update(id, request))
                                .timestamp(LocalDateTime.now())
                                .build();

        }

        @DeleteMapping("/{id}")
        public ApiResponse<Void> delete(
                        @PathVariable Long id) {

                service.delete(id);

                return ApiResponse.<Void>builder()
                                .success(true)
                                .message("Product deleted successfully")
                                .timestamp(LocalDateTime.now())
                                .build();

        }

        @GetMapping("/page")
        public ApiResponse<Page<ProductResponse>> findAll(
                        Pageable pageable) {

                return ApiResponse.<Page<ProductResponse>>builder()
                                .success(true)
                                .message("Success")
                                .data(service.findAll(pageable))
                                .timestamp(LocalDateTime.now())
                                .build();

        }

        @GetMapping("/search")
        public ApiResponse<Page<ProductResponse>> search(

                        @RequestParam String keyword,

                        Pageable pageable) {

                return ApiResponse.<Page<ProductResponse>>builder()
                                .success(true)
                                .message("Success")
                                .data(service.search(keyword, pageable))
                                .timestamp(LocalDateTime.now())
                                .build();

        }
}