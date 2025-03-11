package com.aurionpro.crud.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.crud.entity.Employee;
import com.aurionpro.crud.entity.Role;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	Page<Employee> findByName(String name, Pageable pageable);
	List<Employee> findByRole(Role role);	
}
