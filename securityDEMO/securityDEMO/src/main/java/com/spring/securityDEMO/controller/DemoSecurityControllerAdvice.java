package com.spring.securityDEMO.controller;

import com.spring.securityDEMO.entity.exception.StudentExceptionResponse;
import com.spring.securityDEMO.entity.exception.StudentNotCreatedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DemoSecurityControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<StudentExceptionResponse> exceptionHandler(StudentNotCreatedException exception) {
        StudentExceptionResponse response = new StudentExceptionResponse(HttpStatus.NOT_ACCEPTABLE, exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
    }

}
