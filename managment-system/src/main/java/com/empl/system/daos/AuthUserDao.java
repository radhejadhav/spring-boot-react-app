package com.empl.system.daos;

import com.empl.system.entities.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUserDao extends JpaRepository<AuthUser, Long> {

    AuthUser findByUsername(String username);
}
