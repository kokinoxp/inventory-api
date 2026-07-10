package com.orporsoft.inventory.service.impl;

import com.orporsoft.inventory.dto.request.ProductRequest;
import com.orporsoft.inventory.dto.response.ProductResponse;
import com.orporsoft.inventory.repository.ProductRepository;
import com.orporsoft.inventory.service.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    public ProductResponse create(ProductRequest request) {
        return null;
    }

    @Override
    public List<ProductResponse> findAll() {
        return List.of();
    }

    @Override
    public ProductResponse findById(Long id) {
        return null;
    }

    @Override
    public ProductResponse update(Long id, ProductRequest request) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

}