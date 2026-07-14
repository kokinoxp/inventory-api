package com.orporsoft.inventory.modules.product.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.orporsoft.inventory.modules.product.dto.request.ProductRequest;
import com.orporsoft.inventory.modules.product.dto.response.ProductResponse;
import com.orporsoft.inventory.modules.product.entity.Product;

public interface ProductService {

    ProductResponse create(ProductRequest request);

    List<ProductResponse> findAll();

    ProductResponse findById(Long id);

    ProductResponse update(Long id, ProductRequest request);

    void delete(Long id);
    
    Page<ProductResponse> findAll(Pageable pageable);

    Page<ProductResponse> search(
        String keyword,
        Pageable pageable);

}