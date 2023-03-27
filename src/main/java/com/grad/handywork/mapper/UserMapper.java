package com.grad.handywork.mapper;

import org.mapstruct.Mapper;

import com.grad.handywork.dto.UserDto;
import com.grad.handywork.entity.User;

@Mapper
public interface UserMapper {
	
	UserDto userToUserDto(User user);
	
	User userDtoToUser(UserDto userDto);

}
