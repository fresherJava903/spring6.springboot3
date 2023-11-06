package com.springBoot3.spring6.hibernateJPA.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @Column(name = "vehicle_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "type")
    String type;
    @OneToOne(mappedBy = "vehicle")
    Student personalId;
}
