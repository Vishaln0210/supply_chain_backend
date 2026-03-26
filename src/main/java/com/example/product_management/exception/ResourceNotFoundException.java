package com.example.product_management.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(ErrorCode code) {
        super(code.name());
    }
}