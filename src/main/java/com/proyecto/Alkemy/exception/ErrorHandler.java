package com.proyecto.Alkemy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorInfo> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ErrorInfo errorInfo = new ErrorInfo(ex.getMessage(), HttpStatus.BAD_REQUEST.value(), System.currentTimeMillis(), ex.getBindingResult().toString());
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }


}
