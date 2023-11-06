package com.springBoot3.spring6.hibernateJPA.repository;

import com.springBoot3.spring6.hibernateJPA.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    List<Student> getAllStudents();

    Student findById(Integer id);

    void update(Integer id, String value);

    void deleteStudent(Integer id);

    List<Object[]> names();
}
