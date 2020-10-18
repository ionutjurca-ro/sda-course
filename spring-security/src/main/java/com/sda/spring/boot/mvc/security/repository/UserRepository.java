package com.sda.spring.boot.mvc.security.repository;

import com.sda.spring.boot.mvc.security.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUsername(String username);
}
