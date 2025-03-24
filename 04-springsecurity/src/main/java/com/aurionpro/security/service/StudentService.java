package com.aurionpro.security.service;

import java.util.List;

import com.aurionpro.security.entity.Student;

public interface StudentService {
	boolean addStudent(Student student);
	List<Student> getAllStudents();
}
