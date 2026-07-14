package com.orporsoft.inventory.modules.warehouse.service;

import com.orporsoft.inventory.modules.warehouse.dto.request.WarehouseRequest;
import com.orporsoft.inventory.modules.warehouse.dto.response.WarehouseResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WarehouseService {

    WarehouseResponse create(WarehouseRequest request);

    WarehouseResponse update(Long id, WarehouseRequest request);

    WarehouseResponse findById(Long id);

    Page<WarehouseResponse> search(
            String keyword,
            String status,
            Pageable pageable);

    void delete(Long id);

}