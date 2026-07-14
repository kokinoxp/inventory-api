package com.orporsoft.inventory.modules.warehouse.service;

import com.orporsoft.inventory.exception.DuplicateResourceException;
import com.orporsoft.inventory.exception.ResourceNotFoundException;
import com.orporsoft.inventory.modules.warehouse.dto.request.WarehouseRequest;
import com.orporsoft.inventory.modules.warehouse.dto.response.WarehouseResponse;
import com.orporsoft.inventory.modules.warehouse.entity.Warehouse;
import com.orporsoft.inventory.modules.warehouse.mapper.WarehouseMapper;
import com.orporsoft.inventory.modules.warehouse.repository.WarehouseRepository;
import com.orporsoft.inventory.modules.warehouse.specification.WarehouseSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseRepository repository;
    private final WarehouseMapper mapper;

    @Override
    public WarehouseResponse create(WarehouseRequest request) {

        if (repository.existsByCode(request.getCode())) {
            throw new DuplicateResourceException("Warehouse code already exists");
        }

        Warehouse entity = mapper.toEntity(request);

        return mapper.toResponse(
                repository.save(entity)
        );
    }

    @Override
    public WarehouseResponse update(Long id,
                                    WarehouseRequest request) {

        Warehouse warehouse = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Warehouse not found"));

        if (!warehouse.getCode().equals(request.getCode())
                && repository.existsByCode(request.getCode())) {

            throw new DuplicateResourceException("Warehouse code already exists");
        }

        warehouse.setCode(request.getCode());
        warehouse.setName(request.getName());
        warehouse.setLocation(request.getLocation());
        warehouse.setDescription(request.getDescription());

        return mapper.toResponse(
                repository.save(warehouse)
        );
    }

    @Override
    public WarehouseResponse findById(Long id) {

        Warehouse warehouse = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Warehouse not found"));

        return mapper.toResponse(warehouse);
    }

    @Override
    public Page<WarehouseResponse> search(String keyword,
                                          String status,
                                          Pageable pageable) {

        Specification<Warehouse> specification =
                Specification.where(
                        WarehouseSpecification.keyword(keyword))
                        .and(
                                WarehouseSpecification.status(status));

        return repository.findAll(specification, pageable)
                .map(mapper::toResponse);
    }

    @Override
    public void delete(Long id) {

        Warehouse warehouse = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Warehouse not found"));

        repository.delete(warehouse);
    }

}