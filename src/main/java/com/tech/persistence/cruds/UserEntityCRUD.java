package com.tech.persistence.cruds;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tech.persistence.model.Role;
import com.tech.persistence.model.UserEntity;

public interface UserEntityCRUD extends JpaRepository<UserEntity,String> {
    @Query("SELECT u FROM UserEntity u JOIN u.roles r WHERE r = :role")
    List<UserEntity> FindByRoles(Role role);

}
