package com.aurionpro.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.crud.dto.InstructorRequestDto;
import com.aurionpro.crud.dto.InstructorResponseDto;
import com.aurionpro.crud.entity.Instructor;
import com.aurionpro.crud.repository.InstructorRepository;

@Service
public class InstructorServiceImp implements InstructorService{

	@Autowired
	private InstructorRepository repo;
	
	@Override
	public InstructorResponseDto addInstructor(InstructorRequestDto requestDto) {
		Instructor dbInstructor = repo.save(requestToInstructor(requestDto));
		return instructorToResponse(dbInstructor);
	}
	
	private Instructor requestToInstructor(InstructorRequestDto requestDto) {
		Instructor instructor = new Instructor();
		instructor.setName(requestDto.getName());
		instructor.setQualification(requestDto.getQualification());
		instructor.setExperience(requestDto.getExperience());
		return instructor;
	}
	
	private InstructorResponseDto instructorToResponse(Instructor instructor) {
		InstructorResponseDto responseDto = new InstructorResponseDto();
		responseDto.setName(instructor.getName());
		responseDto.setInstructorId(instructor.getInstructorId());
		responseDto.setExperience(instructor.getExperience());
		responseDto.setQualification(instructor.getQualification());
		return responseDto;
	}

}
