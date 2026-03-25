package com.tech.domain.dtos;

import java.util.Set;

import com.tech.persistence.model.Role;

public record CreateUserDTO(
      String username,
     String password,
     Set<Role> roles
) {}
