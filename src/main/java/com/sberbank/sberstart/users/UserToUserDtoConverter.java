package com.sberbank.sberstart.users;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDtoConverter implements Converter<User, UserDto> {

    @Override
    public UserDto convert(User source) {
        return new UserDto()
                .setAbout(source.getAbout())
                .setAddress(source.getAddress())
                .setBirthDate(source.getBirthDate())
                .setId(source.getId())
                .setLastName(source.getLastName())
                .setName(source.getName());
    }
}
