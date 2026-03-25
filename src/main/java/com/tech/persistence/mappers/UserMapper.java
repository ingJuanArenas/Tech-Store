package com.tech.persistence.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tech.domain.dtos.CreateUserDTO;
import com.tech.domain.dtos.UserDTO;
import com.tech.persistence.model.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "disabled", ignore = true)
   UserEntity toEntity (CreateUserDTO dto);

   UserDTO toDto(UserEntity user);
   List<UserDTO> toDTOs(List<UserEntity> users);
}
