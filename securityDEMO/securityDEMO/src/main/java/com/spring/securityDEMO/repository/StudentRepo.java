package com.spring.securityDEMO.repository;

import com.spring.securityDEMO.entity.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {
}
