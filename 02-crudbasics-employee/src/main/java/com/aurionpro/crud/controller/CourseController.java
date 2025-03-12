package com.aurionpro.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.crud.dto.CourseRequestDto;
import com.aurionpro.crud.dto.CourseResponseDto;
import com.aurionpro.crud.dto.PageResponse;
import com.aurionpro.crud.service.CourseService;

@RestController
@RequestMapping("/app")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/courses")
	public ResponseEntity<CourseResponseDto> addCourses(@RequestBody CourseRequestDto requestDto){
		return ResponseEntity.ok(courseService.addCourse(requestDto));
	}
	
	@GetMapping("/courses")
	public ResponseEntity<PageResponse<CourseResponseDto>> getCourses(@RequestParam int pageSize, @RequestParam int pageNumber){
		return ResponseEntity.ok(courseService.getAllCourses(pageSize, pageNumber));
	}
	
	@GetMapping("/courses/{Id}")
	public ResponseEntity<CourseResponseDto> getCourseById(@PathVariable int Id){
		return ResponseEntity.ok(courseService.getCourseById(Id));
	}
}
