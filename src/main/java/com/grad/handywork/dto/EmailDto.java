package com.grad.handywork.dto;

import com.grad.handywork.validation.UniqueEmail;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmailDto {
	
	@UniqueEmail
	@NotEmpty(message = "Email Field Cannot be empty")
	@Email(message = "Please Enter A Valid Email")
	private String email;

}
