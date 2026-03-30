package com.tech.domain.dtos;


import com.tech.persistence.model.Role;

public record CreateUserDTO(
      String username,
       String password,
       Role role
) {}
