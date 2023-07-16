package com.study.jwtserver.dto;

import com.study.jwtserver.modal.User;
import lombok.Data;

@Data
public class UserDto {
    private String email;
    private String password;

    public static User toEntity(UserDto userDto, String role) {
        return User.builder()
                .email(userDto.email)
                .password(userDto.password)
                .roles(role)
                .build();
    }
}
