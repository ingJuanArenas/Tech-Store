package com.tech.domain.dtos;


import com.tech.persistence.model.Role;

public record UserDTO(

     String username,
     String password,
     boolean disable,
     Role role
) {}
