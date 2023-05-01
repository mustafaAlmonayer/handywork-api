package com.grad.handywork.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobOfferDto {
	
	private Long id;
	
	private String jobTitle;
	
	private Long jobId;
	
	private String jobImageUrl;
	
	private String user;
	
	private String userImageUrl;
	
	@NotNull(message = "Amount Cannot Be Empty")
	private Integer suggestedAmount;
	
	private Boolean accepted;
	
	private Boolean rejected;

}
