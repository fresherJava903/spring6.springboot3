package com.spring.securityDEMO.repository;

import com.spring.securityDEMO.entity.authFollowDefaultSchema.SpringUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringUserRepo extends JpaRepository<SpringUser, String> {
}
