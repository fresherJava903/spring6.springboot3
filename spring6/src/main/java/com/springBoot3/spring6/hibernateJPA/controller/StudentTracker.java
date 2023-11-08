package com.springBoot3.spring6.hibernateJPA.controller;

import com.springBoot3.spring6.hibernateJPA.DTO.StudentDTO;
import com.springBoot3.spring6.hibernateJPA.exception.StudentException;
import com.springBoot3.spring6.hibernateJPA.service.BankAccountService;
import com.springBoot3.spring6.hibernateJPA.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentTracker {
    private StudentService studentService;
    private BankAccountService bankAccountService;
    @Autowired
    public StudentTracker(StudentService studentService, BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Object[]>> getAllNames(){
        return new ResponseEntity<>(studentService.getAllNames(), HttpStatus.ACCEPTED);
//        return studentService.getAllNames();
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addStudent(@RequestBody StudentDTO studentDTO) throws StudentException {
        if (!studentService.createStudent(studentDTO)) {
            throw new StudentException("Failed to create new student");
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
