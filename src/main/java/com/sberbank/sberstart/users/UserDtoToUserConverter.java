package com.sberbank.sberstart.users;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUserConverter implements Converter<UserDto, User> {

    @Override
    public User convert(UserDto source) {
        return new User()
                .setAbout(source.getAbout())
                .setAddress(source.getAddress())
                .setBirthDate(source.getBirthDate())
                .setId(source.getId())
                .setLastName(source.getLastName())
                .setName(source.getName());
    }
}
