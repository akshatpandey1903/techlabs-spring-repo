package com.aurionpro.app.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ErrorResponseDto {
	private String message;
	private long time;
	private int status;
}
