package com.grad.handywork.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.grad.handywork.dto.JobOfferDto;
import com.grad.handywork.entity.JobOffer;

@Mapper
public interface JobOfferMapper {

	@Mapping(target = "jobTitle", source = "job.jobName")
	@Mapping(target = "jobId", source = "job.id")
	@Mapping(target = "jobImageUrl", source = "job.imagesUrls")
	@Mapping(target = "user", source = "user.id")
	@Mapping(target = "userImageUrl", source = "user.pfpUrl")
	JobOfferDto jobOfferToJobOfferDto(JobOffer jobOffer);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "job", ignore = true)
	@Mapping(target = "user", ignore = true)
	@Mapping(target = "accepted", ignore = true)
	@Mapping(target = "rejected", ignore = true)
	JobOffer jobOfferDtoToJobOffer(JobOfferDto jobOfferDto);
	
	default String mapListOfStringToString(List<String> list) {
		return list.get(0);
	}
}
