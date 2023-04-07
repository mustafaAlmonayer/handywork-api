package com.grad.handywork.dto;

import com.grad.handywork.validation.UniquePhoneNumber;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumberDto {
	
	@UniquePhoneNumber
	@NotEmpty(message = "Phone Number Field Cannot be empty")
	@Pattern(regexp = "^07[789][0-9]{7}$", message = "Please Enter A Valid Phone Number")
	private String phoneNumber;

}
