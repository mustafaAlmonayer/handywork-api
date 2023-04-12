package com.grad.handywork.dto;

import java.time.LocalDateTime;
import java.util.List;

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
public class JobDto {
	
	private Long id;
	
	private String owner;
	
	private String doneBy;
	
	private String field;
	
	private String description;
	
	private LocalDateTime publishDate;
	
	@JsonInclude(value = Include.ALWAYS)
	private LocalDateTime updateDate;
	
	private String jobName;
	
	private List<String> imagesUrls;
	
	private Boolean done;
	
    private String city;
    
	private List<String> imagesFiles;

    
}
