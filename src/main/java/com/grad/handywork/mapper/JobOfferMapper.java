package com.grad.handywork.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.grad.handywork.dto.JobOfferDto;
import com.grad.handywork.entity.JobOffer;

@Mapper
public interface JobOfferMapper {

	@Mapping(target = "jobId", source = "id")
	@Mapping(target = "user", source = "user.id")
	JobOfferDto jobOfferToJobOfferDto(JobOffer jobOffer);
	
	@Mapping(target = "job", ignore = true)
	@Mapping(target = "user", ignore = true)
	@Mapping(target = "accepted", ignore = true)
	@Mapping(target = "rejected", ignore = true)
	JobOffer jobOfferDtoToJobOffer(JobOfferDto jobOfferDto);
	
}
