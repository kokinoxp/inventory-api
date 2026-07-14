package com.orporsoft.inventory.modules.supplier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.orporsoft.inventory.modules.supplier.entity.Supplier;

@Repository
public interface SupplierRepository
        extends JpaRepository<Supplier, Long>,
                JpaSpecificationExecutor<Supplier> {

    boolean existsByCode(String code);

}
