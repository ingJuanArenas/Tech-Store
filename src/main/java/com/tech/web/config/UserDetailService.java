package com.tech.web.config;

import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tech.persistence.cruds.UserEntityCRUD;

@Service
public class UserDetailService implements UserDetailsService {

    private final UserEntityCRUD userEntityCRUD;

    

    public UserDetailService(UserEntityCRUD userEntityCRUD) {
        this.userEntityCRUD = userEntityCRUD;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userFound= userEntityCRUD.findById(username)
                                        .orElseThrow(()-> new UsernameNotFoundException("Username not found"));
        String[] roles = List.of(userFound.getRole().name()).toArray(new String[0]);

        System.out.println(userFound.getPassword());
        return User.builder()
                    .username(userFound.getUsername())
                    .password(userFound.getPassword())
                    .authorities(roles)
                    .disabled(userFound.isDisabled())
                    .build();
    }
    
}
