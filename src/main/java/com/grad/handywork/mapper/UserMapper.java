package com.grad.handywork.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.grad.handywork.dto.UserDto;
import com.grad.handywork.entity.User;

@Mapper
public interface UserMapper {
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "password", ignore = true)
	UserDto userToUserDtoForGet(User user);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target= "authorities", ignore = true)
	@Mapping(target= "jobs", ignore = true)
	@Mapping(target="jobOffers", ignore = true)
	@Mapping(target="jobReviews", ignore = true)
	User userDtoToUserForSave(UserDto userDto);
	
}
