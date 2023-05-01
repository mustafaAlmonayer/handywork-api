package com.grad.handywork.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RatingsDto {
	
	private float asListerRating;
	
	private float asProfessionalRating;

}
