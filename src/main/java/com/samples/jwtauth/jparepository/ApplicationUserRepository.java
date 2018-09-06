package com.samples.jwtauth.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samples.jwtauth.model.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);
}