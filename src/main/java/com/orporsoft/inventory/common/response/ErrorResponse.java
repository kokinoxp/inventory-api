package com.orporsoft.inventory.common.response;

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