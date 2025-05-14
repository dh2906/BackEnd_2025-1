package com.example.bcsd.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> notFoundExceptionHandle(CustomException ex) {
        log.error(ex.getMessage());

        return ResponseEntity.status(
                ex.getExceptionMessage()
                        .getStatus()
                )
                .body(ex.getMessage());
    }
}
