package com.aurionpro.app.exceptions;

public class RoleApiException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public RoleApiException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
