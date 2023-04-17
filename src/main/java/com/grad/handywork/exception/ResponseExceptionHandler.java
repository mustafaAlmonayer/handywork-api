package com.grad.handywork.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.grad.handywork.dto.ErrorDetailsDto;
import com.grad.handywork.dto.ErrorDetailsForValidationtDto;

@RestControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ErrorDetailsDto> handleResourceNotFoundExceptionGet(Exception ex, WebRequest request)
			throws Exception {
		ErrorDetailsDto errorDetailsDto = new ErrorDetailsDto(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetailsDto, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ResourceAccessException.class)
	public final ResponseEntity<ErrorDetailsDto> handleResourceAccessException(Exception ex, WebRequest request)
			throws Exception {
		ErrorDetailsDto errorDetails = new ErrorDetailsDto(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(BadUpdateDateException.class)
	public final ResponseEntity<ErrorDetailsForValidationtDto> handleBadUpdateDate(BadUpdateDateException ex, WebRequest request) {
		return new ResponseEntity<>(ex.getErrorDetailsForValidationtDto(), HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		Map<String, String> errorFieldAndDetails = new HashMap<>();
		ex.getFieldErrors().stream()
				.forEach(error -> errorFieldAndDetails.put(error.getField(), error.getDefaultMessage()));
		ErrorDetailsForValidationtDto errorDetailsForValidationtDto = ErrorDetailsForValidationtDto.builder()
				.message(errorFieldAndDetails).build();
		return new ResponseEntity<>(errorDetailsForValidationtDto, HttpStatus.BAD_REQUEST);
	}

}