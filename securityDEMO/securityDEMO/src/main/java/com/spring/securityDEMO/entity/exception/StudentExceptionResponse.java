package com.spring.securityDEMO.entity.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@AllArgsConstructor
public class StudentExceptionResponse {
    HttpStatus status;
    String message;
}
