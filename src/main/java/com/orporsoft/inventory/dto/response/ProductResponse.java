package com.orporsoft.inventory.dto.response;

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

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}