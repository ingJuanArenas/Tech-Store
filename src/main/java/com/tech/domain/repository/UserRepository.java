package com.tech.domain.repository;

import java.util.List;

import com.tech.domain.dtos.CreateUserDTO;
import com.tech.domain.dtos.UserDTO;
import com.tech.persistence.model.Role;

public interface UserRepository {
    
    List<UserDTO> getAll();
    List<UserDTO> getByRole(Role role);
    UserDTO getByUsername(String username);
    UserDTO create(CreateUserDTO user);
    void delete(String username);
}
