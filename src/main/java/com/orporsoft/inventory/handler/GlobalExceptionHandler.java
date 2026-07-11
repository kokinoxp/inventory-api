package com.orporsoft.inventory.handler;

import com.orporsoft.inventory.common.ErrorResponse;
import com.orporsoft.inventory.exception.DuplicateResourceException;
import com.orporsoft.inventory.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> notFound(ResourceNotFoundException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorResponse.builder()
                        .success(false)
                        .status(404)
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build());

    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ErrorResponse> duplicate(DuplicateResourceException ex) {

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(ErrorResponse.builder()
                        .success(false)
                        .status(409)
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build());

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exception(Exception ex) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponse.builder()
                        .success(false)
                        .status(500)
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build());

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> validation(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error -> errors.put(error.getField(),
                        error.getDefaultMessage()));

        ErrorResponse response = ErrorResponse.builder()
                .success(false)
                .status(400)
                .message("Validation failed")
                .errors(errors)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.badRequest().body(response);
    }
}