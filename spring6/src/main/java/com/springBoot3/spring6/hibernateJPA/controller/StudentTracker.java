package com.springBoot3.spring6.hibernateJPA.controller;

import com.springBoot3.spring6.hibernateJPA.service.BankAccountService;
import com.springBoot3.spring6.hibernateJPA.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/names")
    public List<Object[]> getAllNames(){
        return studentService.getAllNames();
    }
}
