package com.aurionpro.app.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.aurionpro.app.error.ErrorResponseDto;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> validationExceptionHandler(MethodArgumentNotValidException e){
		
		Map<String, String> errors = new HashMap<>();
		e.getBindingResult().getFieldErrors().forEach((error) -> {
			errors.put(error.getField(), error.getDefaultMessage());
		});
		
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponseDto> handleApiException(RoleApiException e){
		ErrorResponseDto responseDto = new ErrorResponseDto();
		responseDto.setMessage(e.getMessage());
		responseDto.setStatus(HttpStatus.BAD_REQUEST.value());
		responseDto.setTime(System.currentTimeMillis());
		
		return new ResponseEntity<ErrorResponseDto>(responseDto, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponseDto> handleApiException(UserApiException e){
		ErrorResponseDto responseDto = new ErrorResponseDto();
		responseDto.setMessage(e.getMessage());
		responseDto.setStatus(HttpStatus.BAD_REQUEST.value());
		responseDto.setTime(System.currentTimeMillis());
		
		return new ResponseEntity<ErrorResponseDto>(responseDto, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponseDto> handleApiException(TransactionApiException e){
		ErrorResponseDto responseDto = new ErrorResponseDto();
		responseDto.setMessage(e.getMessage());
		responseDto.setStatus(HttpStatus.BAD_REQUEST.value());
		responseDto.setTime(System.currentTimeMillis());
		
		return new ResponseEntity<ErrorResponseDto>(responseDto, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponseDto> handleApiException(AccountApiException e){
		ErrorResponseDto responseDto = new ErrorResponseDto();
		responseDto.setMessage(e.getMessage());
		responseDto.setStatus(HttpStatus.BAD_REQUEST.value());
		responseDto.setTime(System.currentTimeMillis());
		
		return new ResponseEntity<ErrorResponseDto>(responseDto, HttpStatus.BAD_REQUEST);
	}
}

