package com.grad.handywork.dto;

import java.time.LocalDateTime;

import com.grad.handywork.enumtypes.JobReviewType;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
public class JobReviewDto {
	
	private Long id;
	
	private Long jobId;
	
	private String jobName;
	
	private String byUserUsername;
	
	private String byUserUsernameImageUrl;
	
	private String onUserUsername;

	private String onUserUsernameImageUrl;
	
	private JobReviewType type;
	
	@Min(value = 1, message = "Ratting Cannot Be Less Than 1")
	@Max(value = 5, message = "Ratting Cannot Be More Than 5")
	@NotNull(message = "Ratting Cannot Be Empty")
	private byte rating;
	
	private LocalDateTime publishDate;
	
	private LocalDateTime updateDate;
	
	@NotNull(message = "Review Text Cannot Be Empty")
	@Size(min = 15, max = 512, message = "Description Field Cannot Be Less Than 15 Or bigger Than 512")
	private String reviewText;

}
