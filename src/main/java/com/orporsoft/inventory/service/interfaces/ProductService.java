package com.orporsoft.inventory.service.interfaces;

import com.orporsoft.inventory.dto.request.ProductRequest;
import com.orporsoft.inventory.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse create(ProductRequest request);

    List<ProductResponse> findAll();

    ProductResponse findById(Long id);

    ProductResponse update(Long id, ProductRequest request);

    void delete(Long id);

}