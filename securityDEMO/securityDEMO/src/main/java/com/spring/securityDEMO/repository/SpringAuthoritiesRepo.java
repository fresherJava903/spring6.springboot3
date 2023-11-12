package com.spring.securityDEMO.repository;

import com.spring.securityDEMO.entity.authFollowDefaultSchema.SpringAuthorities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringAuthoritiesRepo extends JpaRepository<SpringAuthorities, String> {
}
