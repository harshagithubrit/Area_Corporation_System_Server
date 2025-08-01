package com.corporation.Corporation.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class GolbalException {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleException (RuntimeException obj){
        return new ResponseEntity<>(obj.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
