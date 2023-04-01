package com.grad.handywork.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobDto {
	
	private Long id;
	
	private String owner;
	
	private String doneBy;
	
	private String field;
	
	private String description;
	
	private LocalDateTime publishDate;
	
	private LocalDateTime updateDate;
	
	private String jobName;
	
	private List<String> imagesUrls;
	
	private boolean done;
	
    private String city;
    
}
