package com.spring.securityDEMO.entity.auth;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authority")
@Getter
@Setter
@NoArgsConstructor
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authority_id")
    private int id;

    @Column(unique = true)
    private String authority;

    @ManyToMany(mappedBy = "authorities")
    private Set<User> users;

    public Authority(String authority, User user) {
        this.authority = authority;
        this.users = new HashSet<>();
        this.users.add(user);
    }

    public void addUser(User user) {
        this.users.add(user);
    }
}
