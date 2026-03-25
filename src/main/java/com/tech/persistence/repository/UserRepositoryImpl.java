package com.tech.persistence.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tech.domain.dtos.CreateUserDTO;
import com.tech.domain.dtos.UserDTO;
import com.tech.domain.exceptions.NotFoundException;
import com.tech.domain.repository.UserRepository;
import com.tech.persistence.cruds.UserEntityCRUD;
import com.tech.persistence.mappers.UserMapper;
import com.tech.persistence.model.Role;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserEntityCRUD uCrud;
    private final UserMapper userMapper;

    
    

    public UserRepositoryImpl(UserEntityCRUD uCrud, UserMapper userMapper) {
        this.uCrud = uCrud;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> getAll() {
        var users = uCrud.findAll();
        return  userMapper.toDTOs(users);
    }

    @Override
    public List<UserDTO> getByRole(Role role) {
       var users = uCrud.FindByRoles(role);
       return userMapper.toDTOs(users);
    }

    @Override
    public UserDTO getByUsername(String username) {
       var user = uCrud.findById(username).orElseThrow(()-> new NotFoundException("Username not found"));
       return userMapper.toDto(user);
    }

    @Override
    public UserDTO create(CreateUserDTO user) {
        var user2save = userMapper.toEntity(user);
        user2save.setDisabled(false);
        var savedUser= uCrud.save(user2save);
        return userMapper.toDto(savedUser);
    }

    @Override
    public void delete(String username) {
        var user = uCrud.findById(username).orElseThrow(()-> new NotFoundException("Username not found"));
        uCrud.delete(user);
    }
    
}
