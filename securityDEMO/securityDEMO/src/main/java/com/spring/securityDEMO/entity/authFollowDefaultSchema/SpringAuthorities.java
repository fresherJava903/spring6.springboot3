package com.spring.securityDEMO.entity.authFollowDefaultSchema;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "authorities")
@Data
public class SpringAuthorities {

    @Id
    private String username;

    @Column(name = "authority")
    private String authority;

    @ManyToOne
    @JoinColumn
    private SpringUser user;
}
