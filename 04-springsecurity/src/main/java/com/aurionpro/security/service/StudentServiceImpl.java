package com.aurionpro.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.aurionpro.security.entity.Student;
import com.aurionpro.security.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepository studentRepo;

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	public boolean addStudent(Student student) {
		studentRepo.save(student);
		return true;
	}

	@Override
	@PreAuthorize("hasAnyRole('ADMIN', 'CUSTOMER')")
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}
	
}
