package com.aurionpro.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.crud.dto.CourseRequestDto;
import com.aurionpro.crud.dto.CourseResponseDto;
import com.aurionpro.crud.service.CourseService;

@RestController
@RequestMapping("/app")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/courses")
	public ResponseEntity<CourseResponseDto> addEmployees(@RequestBody CourseRequestDto requestDto){
		return ResponseEntity.ok(courseService.addCourse(requestDto));
	}
}
