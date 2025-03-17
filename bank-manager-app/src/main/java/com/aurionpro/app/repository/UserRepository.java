package com.aurionpro.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.app.entity.Role;
import com.aurionpro.app.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	Page<User> findByRole(Role role, Pageable pageable);
}
