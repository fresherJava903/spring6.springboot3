package com.springBoot3.spring6.hibernateJPA.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "class")
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @OneToMany(mappedBy = "classRoom")
    private List<Student> students;

    @Column(name = "class_name")
    private String className;

}
