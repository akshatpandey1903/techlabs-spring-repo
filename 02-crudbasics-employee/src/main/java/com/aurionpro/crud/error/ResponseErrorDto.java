package com.aurionpro.crud.error;

public class ResponseErrorDto {
	private String message;
	private long time;
	private int status;
	
	public ResponseErrorDto(String message, long time, int status) {
		super();
		this.message = message;
		this.time = time;
		this.status = status;
	}
	
	public ResponseErrorDto() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "EmployeeResponseError [message=" + message + ", time=" + time + ", status=" + status + "]";
	}
	
}
