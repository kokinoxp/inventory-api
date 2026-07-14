package com.orporsoft.inventory.modules.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.orporsoft.inventory.modules.warehouse.entity.Warehouse;

@Repository
public interface WarehouseRepository
        extends JpaRepository<Warehouse, Long>,
                JpaSpecificationExecutor<Warehouse> {

    boolean existsByCode(String code);

}
