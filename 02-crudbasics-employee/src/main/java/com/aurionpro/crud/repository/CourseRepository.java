package com.aurionpro.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.crud.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

}
