package com.example.product_management.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException(ErrorCode code) {
        super(code.name());
    }
}