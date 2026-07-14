package com.orporsoft.inventory.modules.product.service;

import com.orporsoft.inventory.exception.DuplicateResourceException;
import com.orporsoft.inventory.exception.ResourceNotFoundException;
import com.orporsoft.inventory.modules.product.dto.request.ProductRequest;
import com.orporsoft.inventory.modules.product.dto.response.ProductResponse;
import com.orporsoft.inventory.modules.product.entity.Product;
import com.orporsoft.inventory.modules.product.repository.ProductRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    public ProductResponse create(ProductRequest request) {

        if (repository.existsByCode(request.getCode())) {
            throw new DuplicateResourceException("Product code already exists");
        }

        Product product = Product.builder()
                .code(request.getCode())
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .status("ACTIVE")
                .build();

        Product saved = repository.save(product);

        return mapToResponse(saved);

    }

    @Override
    public List<ProductResponse> findAll() {

        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();

    }

    @Override
    public ProductResponse findById(Long id) {

        Product product = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        return mapToResponse(product);

    }

    @Override
    @Transactional
    public ProductResponse update(Long id, ProductRequest request) {

        Product product = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        Optional<Product> duplicate = repository.findByCode(request.getCode());

        if (duplicate.isPresent() &&
                !duplicate.get().getId().equals(id)) {

            throw new DuplicateResourceException("Product code already exists");
        }

        product.setCode(request.getCode());
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        product.setStatus(request.getStatus());

        Product saved = repository.save(product);

        return mapToResponse(saved);

    }

    @Override
    @Transactional
    public void delete(Long id) {

        Product product = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        repository.delete(product);

    }

    private ProductResponse mapToResponse(Product product) {

        return ProductResponse.builder()
                .id(product.getId())
                .code(product.getCode())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .status(product.getStatus())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();

    }

    @Override
    public Page<ProductResponse> findAll(Pageable pageable) {

        return repository.findAll(pageable)
                .map(this::toResponse);

    }

    private ProductResponse toResponse(Product product) {

        ProductResponse response = new ProductResponse();

        response.setId(product.getId());
        response.setCode(product.getCode());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        response.setQuantity(product.getQuantity());
        response.setStatus(product.getStatus());
        response.setCreatedAt(product.getCreatedAt());
        response.setUpdatedAt(product.getUpdatedAt());

        return response;
    }

    @Override
    public Page<ProductResponse> search(
            String keyword,
            Pageable pageable) {

        return repository
                .findByCodeContainingIgnoreCaseOrNameContainingIgnoreCase(
                        keyword,
                        keyword,
                        pageable)
                .map(this::toResponse);

    }

}