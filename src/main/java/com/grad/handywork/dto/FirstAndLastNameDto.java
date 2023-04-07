package com.grad.handywork.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FirstAndLastNameDto {

	@Size(min = 3, max = 36, message = "First Name Field Must be between 3 and 36")
	private String firstName;
	
	@Size(min = 3, max = 36, message = "Last Name Field Must be between 3 and 36")
	private String lastName;
	
}
