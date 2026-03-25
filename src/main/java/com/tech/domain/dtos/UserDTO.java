package com.tech.domain.dtos;

import java.util.Set;

import com.tech.persistence.model.Role;

public record UserDTO(

     String username,
     String password,
     boolean disable,
     Set<Role> roles
) {}
