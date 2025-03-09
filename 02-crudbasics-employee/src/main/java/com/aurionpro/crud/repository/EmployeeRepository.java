package com.aurionpro.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.crud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
