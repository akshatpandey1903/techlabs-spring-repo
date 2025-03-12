package com.aurionpro.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.crud.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer>{

}
