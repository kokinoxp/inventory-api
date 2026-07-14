package com.orporsoft.inventory.modules.warehouse.mapper;

import org.springframework.stereotype.Component;

import com.orporsoft.inventory.modules.warehouse.dto.request.WarehouseRequest;
import com.orporsoft.inventory.modules.warehouse.dto.response.WarehouseResponse;
import com.orporsoft.inventory.modules.warehouse.entity.Warehouse;

@Component
public class WarehouseMapper {

    public Warehouse toEntity(WarehouseRequest request){

        Warehouse warehouse = new Warehouse();

        warehouse.setCode(request.getCode());
        warehouse.setName(request.getName());
        warehouse.setLocation(request.getLocation());
        warehouse.setDescription(request.getDescription());
        warehouse.setStatus("ACTIVE");

        return warehouse;
    }

    public WarehouseResponse toResponse(Warehouse entity){

        return WarehouseResponse.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .location(entity.getLocation())
                .description(entity.getDescription())
                .status(entity.getStatus())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

}
