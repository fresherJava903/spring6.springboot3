package com.spring.securityDEMO.repository;

import com.spring.securityDEMO.entity.auth.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorityRepo extends JpaRepository<Authority, Integer> {

    @Query("SELECT a FROM Authority a WHERE a.authority = ?1")
    Authority findByAuthority(String authority);
}
