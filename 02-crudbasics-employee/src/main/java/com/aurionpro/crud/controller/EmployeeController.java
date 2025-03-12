package com.aurionpro.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.crud.dto.EmployeeDto;
import com.aurionpro.crud.dto.PageResponse;
import com.aurionpro.crud.entity.Employee;
import com.aurionpro.crud.entity.Role;
import com.aurionpro.crud.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/app")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/employees")
	public ResponseEntity<PageResponse<EmployeeDto>> getEmployees(@RequestParam int pageSize, @RequestParam int pageNumber, @RequestParam(required = false) String name){
		return ResponseEntity.ok(empService.getAllEmployees(pageSize, pageNumber, name));
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> addEmployee(@RequestBody @Valid Employee employee) {
		return ResponseEntity.ok(empService.addEmployee(employee));
	}
	
	@PutMapping("/employees")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok(empService.addEmployee(employee));
	}
	
	@DeleteMapping("/employees")
	public void deleteEmployee(@RequestBody Employee employee) {
		empService.deleteEmployee(employee);
	}
	
	@GetMapping("/employees/{empId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int empId){
		return ResponseEntity.ok(empService.getEmployeeById(empId));
	}
	
//	@GetMapping("/employeesbyname")
//	public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name){
//		return ResponseEntity.ok(empService.getEmployeesByName(name));
//	}
	
	@GetMapping("/employeesbyrole")
	public ResponseEntity<List<Employee>> getEmployeesByRole(@RequestParam Role role){
		return ResponseEntity.ok(empService.getEmployeesByRole(role));
	}
	
}
