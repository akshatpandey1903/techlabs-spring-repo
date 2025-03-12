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

import com.aurionpro.crud.dto.InstructorRequestDto;
import com.aurionpro.crud.dto.InstructorResponseDto;
import com.aurionpro.crud.dto.PageResponse;
import com.aurionpro.crud.service.InstructorService;

@RestController
@RequestMapping("/app")
public class InstructorController {
	
	@Autowired
	private InstructorService instructorService;
	
	@PostMapping("/instructors")
	public ResponseEntity<InstructorResponseDto> addEmployees(@RequestBody InstructorRequestDto requestDto){
		return ResponseEntity.ok(instructorService.addInstructor(requestDto));
	}
	
	@GetMapping("/instructors")
	public ResponseEntity<PageResponse<InstructorResponseDto>> getCourses(@RequestParam int pageSize, @RequestParam int pageNumber){
		return ResponseEntity.ok(instructorService.getAllInstructors(pageSize, pageNumber));
	}
	
	@GetMapping("/instructors/{Id}")
	public ResponseEntity<InstructorResponseDto> getInstructorById(@PathVariable int Id){
		return ResponseEntity.ok(instructorService.getInstructorById(Id));
	}
}
