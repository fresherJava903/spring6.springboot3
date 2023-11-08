package com.spring.securityDEMO.entity.pojo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "student")
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @OneToMany
    private List<Phone> phones;

    public Student(String firstName, String lastName, List<Phone> phones) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phones = phones;
    }
}
