package com.springBoot3.spring6.hibernateJPA.service;

import com.springBoot3.spring6.hibernateJPA.entity.Student;
import com.springBoot3.spring6.hibernateJPA.repository.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class StudentService {
    private StudentDAO studentDAO;
    @Autowired
    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }
    public void deleteStudent() {
        List<Student> students = getAllStudents();
        studentDAO.deleteStudent(students.stream().map(i -> i.getId()).sorted(Comparator.reverseOrder()).findFirst().get());
        System.out.println("Student deleted");
    }
    public void updateStudent() {
        studentDAO.update(2, "thaidang@gmail.com");
        System.out.println("Updated student");
    }
    public List<Student> getAllStudents() {
        List<Student> students = studentDAO.getAllStudents();
//		students.stream().forEach(System.out::println);
        return students;
    }
    public void createStudent() {
        System.out.println("Creating new student...");
        Student student1 = new Student("Vuong", "Dang", "danghvuong94@gmail.com");
        Student student2 = new Student("Tom", "Cat", "tomcat@gmail.com");
        Student student3 = new Student("Jerry", "Mouse", "jerry@gmail.com");
        Student student4 = new Student("Jack", "Pirate", "jack@gmail.com");

        System.out.println("Saving the student to db...");
        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);
        studentDAO.save(student4);
        System.out.println("Saved the student to db!");
    }
    public List<Object[]> getAllNames() {
        return studentDAO.names();
    }
}
