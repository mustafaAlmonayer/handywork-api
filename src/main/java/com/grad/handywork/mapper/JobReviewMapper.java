package com.grad.handywork.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.grad.handywork.dto.JobReviewDto;
import com.grad.handywork.entity.JobReview;

@Mapper
public interface JobReviewMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "job", ignore = true)
	@Mapping(target = "byUser", ignore = true)
	@Mapping(target = "onUser", ignore = true)
	@Mapping(target = "updateDate", ignore = true)
	JobReview jobReviewDtoTojobReview(JobReviewDto jobReviewDto);
	
	@Mapping(target = "jobId", source = "job.id")
	@Mapping(target = "jobName", source = "job.jobName")
	@Mapping(target = "byUserUsername", source = "byUser.username")
	@Mapping(target = "onUserUsername", source = "onUser.username")
	JobReviewDto jobReviewToJobReviewDto(JobReview jobReview);
	
}
