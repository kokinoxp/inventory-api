package com.orporsoft.inventory.repository;

import com.orporsoft.inventory.entity.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByCode(String code);

    boolean existsByCode(String code);

    Page<Product> findByCodeContainingIgnoreCaseOrNameContainingIgnoreCase(
        String code,
        String name,
        Pageable pageable);

}