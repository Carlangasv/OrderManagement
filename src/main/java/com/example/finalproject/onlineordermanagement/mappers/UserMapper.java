package com.example.finalproject.onlineordermanagement.mappers;

import com.example.finalproject.onlineordermanagement.dtos.UserDto;
import com.example.finalproject.onlineordermanagement.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto userToUserDto(User user);
}
