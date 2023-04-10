package com.grad.handywork.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.grad.handywork.dto.JobDto;
import com.grad.handywork.entity.Job;

@Mapper
public interface JobMapper {
	
	@Mapping(source = "owner.username", target= "owner")
	@Mapping(source = "doneBy.username", target= "doneBy", defaultValue = "")
	JobDto jobToJobDto(Job job);
	
	@Mapping(source = "owner.username", target= "owner")
	@Mapping(target = "doneBy", ignore = true)
	@Mapping(target = "done", ignore = true)
	JobDto jobToJobDtoForBrowse(Job job);
	
}
