package com.aurionpro.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.crud.entity.Student;
import com.aurionpro.crud.service.StudentService;

@RestController
@RequestMapping("/app")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return studentService.getAllStudents();
	}
	
}
