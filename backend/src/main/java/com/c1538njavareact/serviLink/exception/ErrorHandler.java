package com.c1538njavareact.serviLink.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(IntegrityValidation.class)
    public ResponseEntity errorHandlerIntegrityValidation(Exception e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
    @ExceptionHandler(AuthValidation.class)
    public ResponseEntity errorHandlerAuthValidation(Exception e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
