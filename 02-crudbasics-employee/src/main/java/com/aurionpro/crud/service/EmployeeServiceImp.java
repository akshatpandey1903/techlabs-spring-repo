package com.aurionpro.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.crud.entity.Employee;
import com.aurionpro.crud.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService{
	
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employees = empRepo.findAll();
		return employees;
	}
	
}
