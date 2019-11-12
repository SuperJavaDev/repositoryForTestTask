package com.sberbank.sberstart.users;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
@ApiModel(value = "Сущность пользователя")
public class UserDto {
    @ApiModelProperty("Уникальный ид")
    private Long id;
    @ApiModelProperty("Имя пользователя")
    private String name;
    @ApiModelProperty("Фамилия пользователя")
    private String lastName;
    @ApiModelProperty("Дата рождения пользователя")
    private Date birthDate;
    @ApiModelProperty("Адресс пользователя")
    private String address;
    @ApiModelProperty("О пользователе")
    private String about;
}
