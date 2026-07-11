package com.orporsoft.inventory.common;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
public class ErrorResponse {

    private boolean success;

    private String message;

    private int status;

    private Map<String, String> errors;

    private LocalDateTime timestamp;

}