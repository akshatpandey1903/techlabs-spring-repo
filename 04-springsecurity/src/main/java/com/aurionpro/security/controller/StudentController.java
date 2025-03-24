package com.aurionpro.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.security.entity.Student;
import com.aurionpro.security.service.StudentService;

@RestController
@RequestMapping("/app")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/students")
	public ResponseEntity<Boolean> addStudent(@RequestBody Student student){
		return ResponseEntity.ok(studentService.addStudent(student));
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents(){
		return ResponseEntity.ok(studentService.getAllStudents());
	}
}
