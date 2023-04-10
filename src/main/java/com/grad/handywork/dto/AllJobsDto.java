package com.grad.handywork.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AllJobsDto {
	
	private List<JobDto> jobs;
	
	private Integer numOfPages;

}
