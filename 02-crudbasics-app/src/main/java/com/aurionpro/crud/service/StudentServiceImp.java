package com.aurionpro.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.crud.entity.Student;
import com.aurionpro.crud.repository.StudentRepository;

@Service
public class StudentServiceImp implements StudentService{
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		List<Student> students = studentRepo.findAll();
		return students;
	}

}
