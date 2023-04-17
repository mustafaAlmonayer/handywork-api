package com.grad.handywork.exception;

import com.grad.handywork.dto.ErrorDetailsForValidationtDto;

public class BadUpdateDateException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private ErrorDetailsForValidationtDto errorDetailsForValidationtDto;

	public BadUpdateDateException(String message, ErrorDetailsForValidationtDto errorDetailsForValidationtDto) {
		super(message);
		this.errorDetailsForValidationtDto = errorDetailsForValidationtDto;
	}

	public ErrorDetailsForValidationtDto getErrorDetailsForValidationtDto() {
		return errorDetailsForValidationtDto;
	}

	public void setErrorDetailsForValidationtDto(ErrorDetailsForValidationtDto errorDetailsForValidationtDto) {
		this.errorDetailsForValidationtDto = errorDetailsForValidationtDto;
	}

}
