package com.orporsoft.inventory.modules.product.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.orporsoft.inventory.modules.product.entity.Product;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByCode(String code);

    boolean existsByCode(String code);

    Page<Product> findByCodeContainingIgnoreCaseOrNameContainingIgnoreCase(
        String code,
        String name,
        Pageable pageable);

}