package com.springBoot3.spring6.hibernateJPA.service;

import com.springBoot3.spring6.hibernateJPA.DTO.StudentDTO;
import com.springBoot3.spring6.hibernateJPA.entity.Student;
import com.springBoot3.spring6.hibernateJPA.exception.StudentException;
import com.springBoot3.spring6.hibernateJPA.mapper.StudentMapper;
import com.springBoot3.spring6.hibernateJPA.repository.StudentDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class StudentService {
    private StudentDAO studentDAO;
    private StudentMapper mapper;
    @Autowired
    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }
    @Autowired
    public void setMapper(StudentMapper mapper) {
        this.mapper = mapper;
    }
    //transaction should be handled at service layer
    @Transactional
    public void deleteStudent() {
        List<Student> students = getAllStudents();
        studentDAO.deleteStudent(students.stream().map(i -> i.getId()).sorted(Comparator.reverseOrder()).findFirst().get());
        System.out.println("Student deleted");
    }
    @Transactional
    public void updateStudent() {
        studentDAO.update(2, "thaidang@gmail.com");
        System.out.println("Updated student");
    }
    public List<Student> getAllStudents() {
        List<Student> students = studentDAO.getAllStudents();
//		students.stream().forEach(System.out::println);
        return students;
    }
    @Transactional
    public boolean createStudent(StudentDTO dto) {
        Student entity = mapper.toEntity(dto);
        try {
            studentDAO.save(entity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public List<Object[]> getAllNames() {
        return studentDAO.names();
    }
}
