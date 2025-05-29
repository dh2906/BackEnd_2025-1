package com.example.bcsd.global.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> ExceptionHandle(CustomException ex, HttpServletRequest request) {
        request.setAttribute("exceptionMessage", ex.getMessage());

        return ResponseEntity.status(
                        ex.getExceptionMessage()
                                .getStatus()
                )
                .body(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> ExceptionHandle(MethodArgumentNotValidException ex, HttpServletRequest request) {
        request.setAttribute("exceptionMessage", ex.getMessage());

        List<String> errorMessages = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        return ResponseEntity.badRequest().body(errorMessages);
    }
}
