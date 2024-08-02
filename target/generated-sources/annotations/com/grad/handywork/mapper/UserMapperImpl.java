package com.grad.handywork.mapper;

import com.grad.handywork.dto.UserDto;
import com.grad.handywork.entity.User;
import com.grad.handywork.enumtypes.Cities;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-02T09:35:49+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.4 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto userToUserDtoForGet(User user) {
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
        userDto.city( mapCities( user.getCity() ) );
        userDto.pfpFile( user.getPfpFile() );

        return userDto.build();
    }

    @Override
    public User userDtoToUserForSave(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( userDto.getUsername() );
        user.setPassword( userDto.getPassword() );
        user.setFirstName( userDto.getFirstName() );
        user.setLastName( userDto.getLastName() );
        user.setEmail( userDto.getEmail() );
        user.setPhoneNumber( userDto.getPhoneNumber() );
        if ( userDto.getCity() != null ) {
            user.setCity( Enum.valueOf( Cities.class, userDto.getCity() ) );
        }
        user.setPfpUrl( userDto.getPfpUrl() );
        user.setPfpFile( userDto.getPfpFile() );

        return user;
    }
}
