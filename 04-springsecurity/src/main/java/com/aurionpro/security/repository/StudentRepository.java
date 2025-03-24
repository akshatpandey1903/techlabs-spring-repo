package com.aurionpro.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.security.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
}
