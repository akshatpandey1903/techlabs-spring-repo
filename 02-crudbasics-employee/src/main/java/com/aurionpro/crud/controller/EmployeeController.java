package com.aurionpro.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.crud.entity.Employee;
import com.aurionpro.crud.service.EmployeeService;

@RestController
@RequestMapping("/app")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return empService.getAllEmployees();
	}
	
}
