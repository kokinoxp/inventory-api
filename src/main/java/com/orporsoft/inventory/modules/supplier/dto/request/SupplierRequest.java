package com.orporsoft.inventory.modules.supplier.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplierRequest {

    @NotBlank(message = "Code is required")
    private String code;

    @NotBlank(message = "Name is required")
    private String name;

    private String contactName;

    private String phone;

    @Email(message = "Invalid email")
    private String email;

    private String address;

    private String taxNo;

}
