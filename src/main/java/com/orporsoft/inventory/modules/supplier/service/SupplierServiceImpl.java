package com.orporsoft.inventory.modules.supplier.service;

import com.orporsoft.inventory.exception.DuplicateResourceException;
import com.orporsoft.inventory.exception.ResourceNotFoundException;
import com.orporsoft.inventory.modules.supplier.dto.request.SupplierRequest;
import com.orporsoft.inventory.modules.supplier.dto.response.SupplierResponse;
import com.orporsoft.inventory.modules.supplier.entity.Supplier;
import com.orporsoft.inventory.modules.supplier.mapper.SupplierMapper;
import com.orporsoft.inventory.modules.supplier.repository.SupplierRepository;
import com.orporsoft.inventory.modules.supplier.specification.SupplierSpecification;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository repository;
    private final SupplierMapper mapper;

    @Override
    public SupplierResponse create(SupplierRequest request) {

        if (repository.existsByCode(request.getCode())) {
            throw new DuplicateResourceException("Supplier code already exists");
        }

        Supplier supplier = mapper.toEntity(request);

        Supplier saved = repository.save(supplier);

        return mapper.toResponse(saved);
    }

    @Override
    public SupplierResponse update(Long id, SupplierRequest request) {

        Supplier supplier = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));

        if (!supplier.getCode().equals(request.getCode())
                && repository.existsByCode(request.getCode())) {

            throw new DuplicateResourceException("Supplier code already exists");
        }

        supplier.setCode(request.getCode());
        supplier.setName(request.getName());
        supplier.setContactName(request.getContactName());
        supplier.setPhone(request.getPhone());
        supplier.setEmail(request.getEmail());
        supplier.setAddress(request.getAddress());
        supplier.setTaxNo(request.getTaxNo());

        Supplier updated = repository.save(supplier);

        return mapper.toResponse(updated);
    }

    @Override
    public SupplierResponse findById(Long id) {

        Supplier supplier = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));

        return mapper.toResponse(supplier);
    }

    @Override
    public List<SupplierResponse> findAll() {

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public void delete(Long id) {

        Supplier supplier = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));

        repository.delete(supplier);
    }

    @Override
    public Page<SupplierResponse> search(
            String keyword,
            String status,
            Pageable pageable) {

        Specification<Supplier> specification = Specification.where(
                SupplierSpecification.keyword(keyword))
                .and(
                        SupplierSpecification.status(status));

        return repository
                .findAll(specification, pageable)
                .map(mapper::toResponse);

    }

}