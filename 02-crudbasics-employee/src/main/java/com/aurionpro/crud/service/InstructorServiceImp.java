package com.aurionpro.crud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aurionpro.crud.dto.InstructorRequestDto;
import com.aurionpro.crud.dto.InstructorResponseDto;
import com.aurionpro.crud.dto.PageResponse;
import com.aurionpro.crud.entity.Instructor;
import com.aurionpro.crud.exceptions.InstructorApiException;
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

	@Override
	public PageResponse<InstructorResponseDto> getAllInstructors(int pageSize, int pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Instructor> instructors = null;
		
		instructors = repo.findAll(pageable);
		
		List<Instructor> coursesList = instructors.getContent();
		List<InstructorResponseDto> instructorDto = new ArrayList<>();
		for(Instructor course : coursesList) {
			instructorDto.add(instructorToResponse(course));
		}
		
		PageResponse<InstructorResponseDto> pageResponse = new PageResponse<>();
		pageResponse.setContent(instructorDto);
		pageResponse.setLast(instructors.isLast());
		pageResponse.setPageSize(instructors.getSize());
		pageResponse.setTotalPages(instructors.getTotalPages());
		pageResponse.setTotalElements(instructors.getTotalElements());
		return pageResponse;
	}

	@Override
	public InstructorResponseDto getInstructorById(int id) {
		Optional<Instructor> instructorDb = repo.findById(id);
		
		if(instructorDb.isEmpty()) {
			throw new InstructorApiException("Instructor by this id does not exist");
		}
		
		InstructorResponseDto responseDto = instructorToResponse(instructorDb.get());
		return responseDto;
	}

}
