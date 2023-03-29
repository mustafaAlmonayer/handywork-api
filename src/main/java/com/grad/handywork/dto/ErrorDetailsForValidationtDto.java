package com.grad.handywork.dto;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetailsForValidationtDto {

	private LocalDateTime timestamp;
	
	private Map<String, String> message;
	
	private String details;

}
