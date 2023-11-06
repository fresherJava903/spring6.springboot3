package com.springBoot3.spring6.hibernateJPA.service;

import com.springBoot3.spring6.hibernateJPA.repository.BankAccountRepo;
import com.springBoot3.spring6.hibernateJPA.repository.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountService {
    private BankAccountRepo bankAccountRepo;
    private StudentDAO studentDAO;
    @Autowired
    public BankAccountService(BankAccountRepo bankAccountRepo, StudentDAO studentDAO) {
        this.bankAccountRepo = bankAccountRepo;
        this.studentDAO = studentDAO;
    }
}
