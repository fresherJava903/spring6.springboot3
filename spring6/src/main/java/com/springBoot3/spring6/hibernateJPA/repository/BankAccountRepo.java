package com.springBoot3.spring6.hibernateJPA.repository;

import com.springBoot3.spring6.hibernateJPA.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepo extends JpaRepository<BankAccount, Integer> {
}
