package com.orporsoft.inventory.modules.supplier.dto.response;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SupplierResponse {

    private Long id;

    private String code;

    private String name;

    private String contactName;

    private String phone;

    private String email;

    private String address;

    private String taxNo;

    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
