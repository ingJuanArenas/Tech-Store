package com.tech.web.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tech.domain.dtos.CreateUserDTO;
import com.tech.domain.dtos.UserDTO;
import com.tech.domain.service.UserService;
import com.tech.persistence.model.Role;


@RestController
@RequestMapping("/auth")
public class UsersController {
    
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll (){
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{role}")
    public ResponseEntity<List<UserDTO>>getByRole(@PathVariable Role role){
        return ResponseEntity.ok(userService.getByRole(role));
    }

    @GetMapping("/search")
    public ResponseEntity<UserDTO> getByUsername(@RequestParam String username){
        return ResponseEntity.ok(userService.getByUsername(username));
    }



    @PostMapping
    public ResponseEntity<UserDTO> create (@RequestBody CreateUserDTO user){
        return ResponseEntity.ok(userService.create(user));
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Void> delete(@PathVariable String username){
        userService.delete(username);
        return ResponseEntity.noContent().build();
    }
    

}
