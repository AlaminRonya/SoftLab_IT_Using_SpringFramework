package com.alamin.converter;

import com.alamin.dto.UserDTO;
import com.alamin.models.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class UserConverter {

    public UserDTO entityToDto(User user){
        return new ModelMapper().map(user, UserDTO.class);
    }

    public User DtoToEntity(UserDTO userDTO){
        return new ModelMapper().map(userDTO, User.class);
    }

    public List<UserDTO> entityToDto(List<User> users) {
        return	users.stream().map(this::entityToDto).collect(Collectors.toList());
    }
}
