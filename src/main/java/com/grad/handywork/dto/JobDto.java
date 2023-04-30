package com.grad.handywork.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
@JsonInclude(Include.NON_NULL)
public class JobDto {
	
	private Long id;
	
	private String owner;
	
	private String doneBy;
	
    @Size(min = 3, max = 36, message = "\"Field\" Field Cannot Be Less Than 3 Or bigger Than 36")
    @NotNull(message = "\"Field\" Field cannot be empty")
	private String field;
	
    @NotNull(message = "Description Field Cannot Be Empty")
    @Size(min = 15, max = 512, message =  "Description Field Cannot Be Less Than 15 Or bigger Than 512")
	private String description;
	
	private LocalDateTime publishDate;
	
	@JsonInclude(value = Include.ALWAYS)
	private LocalDateTime updateDate;
	
    @Size(min = 3, max = 36, message =  "Tile Field Cannot Be Less Than 3 Or bigger Than 36")
    @NotNull(message = "Cannot Be Empty")
	private String jobName;
	
	private List<String> imagesUrls;
	
	private Boolean done;
	
    @Size(min = 3, max = 36, message =  "City Field Cannot Be Less Than 3 Or bigger Than 36")
    private String city;
    
    @Size(max = 5, message = "Cannot Have More than 5 images")
	private List<String> imagesFiles;

    
}
