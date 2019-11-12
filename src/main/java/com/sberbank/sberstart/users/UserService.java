package com.sberbank.sberstart.users;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserToUserDtoConverter userToUserDtoConverter;
    private final UserDtoToUserConverter userDtoToUserConverter;

    /**
     * Метод для создания новых пользователей
     * @param userDto - сущность с данными о пользователе, для общения по сети
     * @return userDto - сущность с данными о пользователе, для общения по сети
     */
    @Transactional
    public UserDto create(UserDto userDto) {
        log.info("Try create user by userInfo {}", userDto);
        User user = userDtoToUserConverter.convert(userDto);
        User savedUser = userRepository.save(user);
        log.info("User successful created with param {}", user);
        return userToUserDtoConverter.convert(savedUser);
    }

    /**
     * метод для получения пользователя по id
     * @param userId - уникальный ид пользователя
     * @return userDto - сущность с данными о пользователе, для общения по сети
     */
    @Transactional(readOnly = true)
    public UserDto get(long userId) {
        log.info("Try get user by id {}", userId);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Can't find user by id: " + userId));
        log.info("Fended user with data {}", user);
        return userToUserDtoConverter.convert(user);
    }

    /**
     * метод нужен для получения списка всех пользователей
     * @return - Список пользователей dto
     */
    @Transactional(readOnly = true)
    public List<UserDto> get() {
        log.info("Try get all users");
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userToUserDtoConverter::convert)
                .collect(Collectors.toList());
    }

    /**
     * метод нужен для удаления пользователя
     * @param userId - уникальный ид пользователя
     */
    @Transactional
    public void remove(long userId) {
        log.info("Try remove user by id {}", userId);
        userRepository.deleteById(userId);
        log.info("Successful remove user by id {}", userId);
    }

    /**
     * метод нужен для обновления данных о пользователе
     * @param userDto - сущность с данными о пользователе, для общения по сети
     * @return userDto - сущность с данными о пользователе, для общения по сети
     */
    @Transactional
    public UserDto update(UserDto userDto) {
        log.info("Try update user to new data {}", userDto);
        boolean userExisted = userRepository.findById(userDto.getId())
                .isPresent();
        if (!userExisted) {
            throw new UserNotFoundException("Can't find user by id: " + userDto.getId());
        }
        User user = userDtoToUserConverter.convert(userDto);
        User savedUser = userRepository.save(user);
        log.info("Successful update user data {}", user);
        return userToUserDtoConverter.convert(savedUser);
    }
}
