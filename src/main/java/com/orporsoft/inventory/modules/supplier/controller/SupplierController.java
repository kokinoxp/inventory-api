package com.orporsoft.inventory.modules.supplier.controller;

import com.orporsoft.inventory.common.response.ApiResponse;
import com.orporsoft.inventory.modules.supplier.dto.request.SupplierRequest;
import com.orporsoft.inventory.modules.supplier.dto.response.SupplierResponse;
import com.orporsoft.inventory.modules.supplier.service.SupplierService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
@RequiredArgsConstructor
public class SupplierController {

        private final SupplierService service;

        @PostMapping
        public ApiResponse<SupplierResponse> create(
                        @Valid @RequestBody SupplierRequest request) {

                return ApiResponse.<SupplierResponse>builder()
                                .success(true)
                                .message("Supplier created successfully")
                                .data(service.create(request))
                                .timestamp(LocalDateTime.now())
                                .build();
        }

        @GetMapping
        public ApiResponse<Page<SupplierResponse>> search(

                        @RequestParam(defaultValue = "") String keyword,

                        @RequestParam(required = false) String status,

                        @ParameterObject
                        @PageableDefault
                        (size = 10, sort = "name") Pageable pageable) {

                return ApiResponse.<Page<SupplierResponse>>builder()
                                .success(true)
                                .message("Success")
                                .data(service.search(keyword, status, pageable))
                                .timestamp(LocalDateTime.now())
                                .build();
        }

        @GetMapping("/{id}")
        public ApiResponse<SupplierResponse> findById(
                        @PathVariable Long id) {

                return ApiResponse.<SupplierResponse>builder()
                                .success(true)
                                .message("Success")
                                .data(service.findById(id))
                                .timestamp(LocalDateTime.now())
                                .build();
        }

        @PutMapping("/{id}")
        public ApiResponse<SupplierResponse> update(
                        @PathVariable Long id,
                        @Valid @RequestBody SupplierRequest request) {

                return ApiResponse.<SupplierResponse>builder()
                                .success(true)
                                .message("Supplier updated successfully")
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
                                .message("Supplier deleted successfully")
                                .timestamp(LocalDateTime.now())
                                .build();
        }

}