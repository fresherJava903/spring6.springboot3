package com.springBoot3.spring6.hibernateJPA.mapper;

import com.springBoot3.spring6.hibernateJPA.DTO.StudentDTO;
import com.springBoot3.spring6.hibernateJPA.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public Student toEntity(StudentDTO dto) {
        return new Student(dto.getFirstName(), dto.getLastName(), dto.getEmail());
    }
    public StudentDTO toDTO(Student student) {
        return new StudentDTO(student.getFirstName(), student.getLastName(), student.getEmail());
    }
}
