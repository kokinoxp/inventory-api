package com.orporsoft.inventory.modules.product.dto.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {

    private Long id;

    private String code;

    private String name;

    private String description;

    private BigDecimal price;

    private Integer quantity;

    private String status;

    private Long categoryId;

    private String categoryCode;

    private String categoryName;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}