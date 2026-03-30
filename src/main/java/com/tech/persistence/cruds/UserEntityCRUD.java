package com.tech.persistence.cruds;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.persistence.model.Role;
import com.tech.persistence.model.UserEntity;

public interface UserEntityCRUD extends JpaRepository<UserEntity,String> {
    List<UserEntity> findByRole(Role role);
}
