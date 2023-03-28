package com.grad.handywork.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
	
	private String username;

	private String password;
	
	private String firstName;
	
	private String lastName;

	private String email;

	private String phoneNumber;

	private String pfpUrl;
	
	private String city;
	
	private String pfpFile;
	
}
