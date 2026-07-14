package com.orporsoft.inventory.modules.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.orporsoft.inventory.modules.category.entity.Category;

@Repository
public interface CategoryRepository extends
        JpaRepository<Category,Long>,
        JpaSpecificationExecutor<Category>{

    boolean existsByCode(String code);

}
