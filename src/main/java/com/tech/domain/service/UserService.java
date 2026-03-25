package com.tech.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tech.domain.dtos.CreateUserDTO;
import com.tech.domain.dtos.UserDTO;
import com.tech.domain.exceptions.NotFoundException;
import com.tech.persistence.model.Role;
import com.tech.persistence.repository.UserRepositoryImpl;

@Service
public class UserService {
    
    private final UserRepositoryImpl userRepository;

    public UserService(UserRepositoryImpl userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getAll(){
        var users = userRepository.getAll();
        if(users.isEmpty()) throw new NotFoundException("No contents found");

        return users;
    }

    public List<UserDTO> getByRole(Role role){
        var users = userRepository.getByRole(role);
        if (users.isEmpty()) throw new NotFoundException("No contents found");

        return users;
    }

    public UserDTO getByUsername(String username){
        return userRepository.getByUsername(username);
    }

    public UserDTO create( CreateUserDTO userDTO){
        return userRepository.create(userDTO);
    }

    public void delete (String username){
        userRepository.delete(username);
    }
}
