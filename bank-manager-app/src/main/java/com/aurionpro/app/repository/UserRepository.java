package com.aurionpro.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.app.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
