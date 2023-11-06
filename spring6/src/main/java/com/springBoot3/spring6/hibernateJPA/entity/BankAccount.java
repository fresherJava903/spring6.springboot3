package com.springBoot3.spring6.hibernateJPA.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bank_account")
@NoArgsConstructor
@Getter
@Setter
public class BankAccount {

    @Id
    @Column(name = "personal_id")
    int id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "personal_id")
    private Student student;

    @Column(name = "value")
    int value;

    @Column(name = "account")
    private long account;

    public BankAccount(int value, long account, Student student) {
        this.value = value;
        this.account = account;
        this.student = student;
    }
}
