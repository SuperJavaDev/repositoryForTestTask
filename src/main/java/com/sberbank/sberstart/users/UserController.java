package com.sberbank.sberstart.users;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Api(value = "Сервис управления пользователями")
public class UserController {

    private final UserService userService;

    @PostMapping
    @ApiOperation("Создание нового пользователя")
    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.create(userDto));
    }

    @GetMapping
    @ApiOperation("Получение всех пользователей")
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(userService.get());
    }

    @GetMapping("/{id}")
    @ApiOperation("Получение пользователя по Id")
    public ResponseEntity<UserDto> get(@PathVariable("id") long userId) {
        return ResponseEntity.ok(userService.get(userId));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Удаление пользователя по id")
    public ResponseEntity<Void> remove(@PathVariable("id") long userId) {
        userService.remove(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    @ApiOperation("Обновление информации о пользователе")
    public ResponseEntity<UserDto> update(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.update(userDto));
    }
}
