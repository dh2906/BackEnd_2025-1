package com.example.bcsd.global.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    private final ExceptionMessage exceptionMessage;

    public CustomException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage.getMessage());
        this.exceptionMessage = exceptionMessage;
    }
}
