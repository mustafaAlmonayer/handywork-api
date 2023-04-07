package com.grad.handywork.dto;

import com.grad.handywork.validation.UniqueUsername;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsernameDto {
	
	@UniqueUsername
	@NotNull(message = "Username Field Cannot Be Empty")
	@Size(min = 4, max = 36, message = "Username Field Must Be Between 4 And 36")
	private String username;

}
