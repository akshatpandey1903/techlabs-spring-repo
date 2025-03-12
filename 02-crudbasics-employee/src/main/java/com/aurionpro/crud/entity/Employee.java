package com.aurionpro.crud.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="employees")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Employee {
	
	@Column(name="empId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	@Column
	@NotBlank(message = "Name input is compulsory")
	private String name;
	@Column
	@NotNull
	@Min(value = 1)
	private double salary;
	@Column
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId")
	private Address address;
	
}
