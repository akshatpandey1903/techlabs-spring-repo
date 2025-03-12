package com.aurionpro.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.crud.dto.InstructorRequestDto;
import com.aurionpro.crud.dto.InstructorResponseDto;
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
}
