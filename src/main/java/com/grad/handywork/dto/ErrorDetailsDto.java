package com.grad.handywork.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetailsDto {

	private LocalDateTime timestamp;
	
	private String message;
	
	private String details;

}
