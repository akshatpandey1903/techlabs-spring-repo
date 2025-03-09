package com.aurionpro.crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employees")
public class Employee {
	
	@Column(name="empId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	@Column
	private String name;
	@Column
	private double salary;
	@Column
	@Enumerated(EnumType.STRING)
	private Role role;
	
	public Employee(int empId, String name, double salary, Role role) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.role = role;
	}

	public Employee() {
		super();
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", salary=" + salary + ", role=" + role + "]";
	}
	
}
