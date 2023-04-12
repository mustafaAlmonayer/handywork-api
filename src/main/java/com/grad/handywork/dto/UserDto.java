package com.grad.handywork.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.grad.handywork.validation.UniqueEmail;
import com.grad.handywork.validation.UniquePhoneNumber;
import com.grad.handywork.validation.UniqueUsername;

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
@JsonInclude(Include.NON_NULL)
public class UserDto {
	
	private Long id;
	
	@NotNull(message = "Username Field Cannot Be Empty")
	@Size(min = 4, max = 36, message = "Username Field Must Be Between 4 And 36")
	@UniqueUsername
	private String username;

	@NotNull(message = "Password Field Cannot Be Empty")
	@Size(min = 8, message = "Password Field Must Be 8 Or More")
	private String password;
	
	@JsonInclude(value = Include.ALWAYS)
	@Size(min = 3, max = 36, message = "First Name Field Must be between 3 and 36")
	private String firstName;
	
	@JsonInclude(value = Include.ALWAYS)
	@Size(min = 3, max = 36, message = "Last Name Field Must be between 3 and 36")
	private String lastName;

	@NotEmpty(message = "Email Field Cannot be empty")
	@Email(message = "Please Enter A Valid Email")
	@UniqueEmail
	private String email;
	
	@NotEmpty(message = "Phone Number Field Cannot be empty")
	@Pattern(regexp = "^07[789][0-9]{7}$", message = "Please Enter A Valid Phone Number")
	@UniquePhoneNumber
	private String phoneNumber;

	private String pfpUrl;
	
	@NotNull(message = "City Field Cannot be empty")
	@Size(min = 3, message = "City Field Cannot Be Less than 3")
	private String city;
	
	private String pfpFile;
	
}
