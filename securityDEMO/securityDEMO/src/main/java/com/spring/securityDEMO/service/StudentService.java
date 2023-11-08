package com.spring.securityDEMO.service;

import com.spring.securityDEMO.entity.dto.StudentDTO;
import com.spring.securityDEMO.entity.pojo.Student;
import com.spring.securityDEMO.mapper.StudentMapper;
import com.spring.securityDEMO.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private StudentMapper mapper;
    private StudentRepo studentRepo;
    @Autowired
    public StudentService(StudentMapper mapper, StudentRepo studentRepo) {
        this.mapper = mapper;
        this.studentRepo = studentRepo;
    }

    public boolean createStudent(StudentDTO studentDTO) {
        try {
            Student student = mapper.toEntity(studentDTO);
            studentRepo.save(student);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
