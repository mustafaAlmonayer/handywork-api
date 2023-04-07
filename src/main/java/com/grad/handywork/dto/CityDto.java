package com.grad.handywork.dto;

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
public class CityDto {
	
	@NotNull(message = "City Field Cannot be empty")
	@Size(min =3, message = "City Field Cannot Be Less than 3")
	private String city;

}
