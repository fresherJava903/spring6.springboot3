package com.springBoot3.spring6.hibernateJPA.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @Column(name = "teacher_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "subject")
    private String subject;

    @ManyToMany(mappedBy = "teachers")
    private Set<Student> students = new HashSet<>();
}
