package com.springBoot3.spring6.hibernateJPA.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
@NoArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    //common way, there's a field for `vehicle_id` in table `student`
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id", referencedColumnName = "vehicle_id")
    private Vehicle vehicle;

    //using shared primary key, there's no need to create additionally a field for account_id in `student` table
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private BankAccount bankAccount;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private ClassRoom classRoom;

    @ManyToMany
    @JoinTable(
            name = "student_teacher",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "teacher_id")}
    )
    private Set<Teacher> teachers = new HashSet<>();

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String toString() {
        return String.format("""
                Student: %s %s
                ID: %2d
                Email: %s
                """, firstName, lastName, id, email);
    }
}