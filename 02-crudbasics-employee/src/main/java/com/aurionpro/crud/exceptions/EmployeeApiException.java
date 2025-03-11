package com.aurionpro.crud.exceptions;

public class EmployeeApiException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public EmployeeApiException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
