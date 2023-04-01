package com.grad.handywork.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.grad.handywork.dto.JobDto;
import com.grad.handywork.entity.Job;

@Mapper
public interface JobMapper {
	
	@Mapping(source = "owner.username", target= "owner")
	@Mapping(source = "doneBy.username", target= "doneBy")
	JobDto jobToJobDto(Job job);
	

}
