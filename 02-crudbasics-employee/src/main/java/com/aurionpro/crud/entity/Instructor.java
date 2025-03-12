package com.aurionpro.crud.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="instructors")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Instructor {
	@Column(name="instructorId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int instructorId;
	@Column
	private String name;
	@Column
	private String qualification;
	@Column
	private int experience;
	
	@OneToMany(cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE}, mappedBy = "instructor")
	private List<Course> courses;
}
