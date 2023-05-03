package com.grad.handywork.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.grad.handywork.dto.UserDto;
import com.grad.handywork.entity.User;
import com.grad.handywork.enumtypes.Cities;

@Mapper
public interface UserMapper {
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "password", ignore = true)
	UserDto userToUserDtoForGet(User user);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target= "authorities", ignore = true)
	@Mapping(target= "jobs", ignore = true)
	@Mapping(target="jobOffers", ignore = true)
	@Mapping(target="ownedJobReviews", ignore = true)
	@Mapping(target="onJobReviews", ignore = true)
	User userDtoToUserForSave(UserDto userDto);
	
	default String mapCities(Cities cities) {
		String conversion;
		if (cities.equals(Cities.MAAN)) {
			conversion = "Ma'an";
		} else {
			conversion = cities.toString().charAt(0) + cities.toString().substring(1).toLowerCase();
		}
		return conversion;
	}
	
}
