package com.grad.handywork.dto;

import com.grad.handywork.enumtypes.Cities;

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
public class JobUpdateDto {
	
	@NotNull(message = "Cannot Be Empty")
	private String jobName;
	
	@Size(min = 15, message =  "Description Field Cannot Be Less Than 15")
	private String description;
	
	@NotNull(message = "City Cannot Be Empty")
	private Cities city;
	
	@NotNull(message = "\"Field\" Field cannot be empty")
	private String field;

}
