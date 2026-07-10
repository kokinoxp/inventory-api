package com.orporsoft.inventory.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest {

    @NotBlank
    private String code;

    @NotBlank
    private String name;

    private String description;

    @NotNull
    @DecimalMin("0.00")
    private BigDecimal price;

    @NotNull
    @Min(0)
    private Integer quantity;

}