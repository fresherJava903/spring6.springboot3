package com.spring.securityDEMO.entity.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
@Entity
@Table(name = "phone")
@NoArgsConstructor
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String type;
    @Column(unique = true)
    private long number;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    public Phone(String type, long number) {
        this.type = type;
        this.number = number;
    }
}
