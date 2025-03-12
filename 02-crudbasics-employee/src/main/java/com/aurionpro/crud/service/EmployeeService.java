package com.aurionpro.crud.service;

import java.util.List;

import com.aurionpro.crud.dto.EmployeeDto;
import com.aurionpro.crud.dto.PageResponse;
import com.aurionpro.crud.entity.Employee;
import com.aurionpro.crud.entity.Role;

public interface EmployeeService {
	
	PageResponse<EmployeeDto> getAllEmployees(int pageSize, int pageNumber, String name);
	
	Employee addEmployee(Employee employee);
	
	void deleteEmployee(Employee employee);
	
	Employee getEmployeeById(int empId);
	
//	List<Employee> getEmployeesByName(String name);
	
	List<Employee> getEmployeesByRole(Role role);
}
