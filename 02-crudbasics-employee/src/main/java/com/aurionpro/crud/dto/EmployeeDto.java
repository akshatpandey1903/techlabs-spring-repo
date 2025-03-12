package com.aurionpro.crud.dto;

import com.aurionpro.crud.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class EmployeeDto {
	
	private int empId;
	private String name;
	private double salary;
	private Role role;
}
