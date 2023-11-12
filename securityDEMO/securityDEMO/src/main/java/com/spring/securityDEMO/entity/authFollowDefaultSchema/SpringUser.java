package com.spring.securityDEMO.entity.authFollowDefaultSchema;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class SpringUser {
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "enabled")
    private byte enabled;

    @OneToMany(mappedBy = "user")
    private Set<SpringAuthorities> authorities;
}
