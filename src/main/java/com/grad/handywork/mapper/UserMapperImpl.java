package com.grad.handywork.mapper;

import org.springframework.stereotype.Component;

import com.grad.handywork.dto.UserDto;
import com.grad.handywork.entity.User;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto.UserDtoBuilder userDto = UserDto.builder();

        userDto.username( user.getUsername() );
        userDto.firstName( user.getFirstName() );
        userDto.lastName( user.getLastName() );
        userDto.email( user.getEmail() );
        userDto.phoneNumber( user.getPhoneNumber() );
        userDto.pfpUrl( user.getPfpUrl() );
        userDto.city( user.getCity() );

        return userDto.build();
    }

    @Override
    public User userDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( userDto.getUsername() );
        user.setFirstName( userDto.getFirstName() );
        user.setLastName( userDto.getLastName() );
        user.setEmail( userDto.getEmail() );
        user.setPhoneNumber( userDto.getPhoneNumber() );
        user.setCity( userDto.getCity() );
        user.setPfpUrl( userDto.getPfpUrl() );

        return user;
    }
}

