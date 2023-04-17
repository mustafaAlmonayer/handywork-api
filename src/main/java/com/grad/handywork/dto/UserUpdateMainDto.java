package com.grad.handywork.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateMainDto {

	@NotNull(message = "First Name Field Cannot Be Empty")
	@Size(min = 3, max = 36, message = "First Name Field Must be between 3 and 36")
	private String firstName;
	
	@NotNull(message = "First Name Field Cannot Be Empty")
	@Size(min = 3, max = 36, message = "Last Name Field Must be between 3 and 36")
	private String lastName;
	
	@NotEmpty(message = "Email Field Cannot be empty")
	@Email(message = "Please Enter A Valid Email")
	private String email;
	
	@NotEmpty(message = "Phone Number Field Cannot be empty")
	@Pattern(regexp = "^07[789][0-9]{7}$", message = "Please Enter A Valid Phone Number")
	private String phoneNumber;
	
	@NotNull(message = "City Field Cannot be empty")
	@Size(min =3, message = "City Field Cannot Be Less than 3")
	private String city;
	
}
