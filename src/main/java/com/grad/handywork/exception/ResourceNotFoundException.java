package com.grad.handywork.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -5396888588608632428L;

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
