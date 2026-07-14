package com.orporsoft.inventory.modules.supplier.mapper;

import org.springframework.stereotype.Component;

import com.orporsoft.inventory.modules.supplier.dto.request.SupplierRequest;
import com.orporsoft.inventory.modules.supplier.dto.response.SupplierResponse;
import com.orporsoft.inventory.modules.supplier.entity.Supplier;

@Component
public class SupplierMapper {

    public Supplier toEntity(SupplierRequest request) {

        Supplier supplier = new Supplier();

        supplier.setCode(request.getCode());
        supplier.setName(request.getName());
        supplier.setContactName(request.getContactName());
        supplier.setPhone(request.getPhone());
        supplier.setEmail(request.getEmail());
        supplier.setAddress(request.getAddress());
        supplier.setTaxNo(request.getTaxNo());
        supplier.setStatus("ACTIVE");

        return supplier;
    }

    public SupplierResponse toResponse(Supplier entity) {

        return SupplierResponse.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .contactName(entity.getContactName())
                .phone(entity.getPhone())
                .email(entity.getEmail())
                .address(entity.getAddress())
                .taxNo(entity.getTaxNo())
                .status(entity.getStatus())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
