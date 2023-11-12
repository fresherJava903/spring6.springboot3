package com.spring.securityDEMO.controller;

import com.spring.securityDEMO.entity.dto.StudentDTO;
import com.spring.securityDEMO.entity.exception.StudentNotCreatedException;
import com.spring.securityDEMO.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private StudentService service;
    public void setService(StudentService service) {
        this.service = service;
    }

//    //Exception handler work only for RestController
//    @ExceptionHandler
//    public ResponseEntity<StudentExceptionResponse> exceptionHandler(StudentNotCreatedException exception) {
//        StudentExceptionResponse response = new StudentExceptionResponse(HttpStatus.NOT_ACCEPTABLE, exception.getMessage());
//        return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
//    }

    @GetMapping("/")
    public ResponseEntity<String> hello() {
        String greeting = "Hello there!";
        return new ResponseEntity<>(greeting, HttpStatus.ACCEPTED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<String>> getAll() {
        List<String> rs = List.of("field1", "field2", "field3");
        return new ResponseEntity<>(rs, HttpStatus.ACCEPTED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> findById(@PathVariable int id) {
        String rs = new StringBuffer("Object found with id:").append(id).toString();
        return new ResponseEntity<>(rs, HttpStatus.FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createObject(@RequestBody StudentDTO studentDTO) throws StudentNotCreatedException {
        if (!service.createStudent(studentDTO)) {
            throw new StudentNotCreatedException("Failed to create student");
        }
        return new ResponseEntity<>("Student created!", HttpStatus.CREATED);
    }
}
