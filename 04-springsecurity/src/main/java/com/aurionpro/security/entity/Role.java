package com.aurionpro.security.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "roles")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Role {
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleId;
	@Column
	private String roleName;
}
