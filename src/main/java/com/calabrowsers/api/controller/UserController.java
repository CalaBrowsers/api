package com.calabrowsers.api.controller;

import com.calabrowsers.api.dto.UserCreateDto;
import com.calabrowsers.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<Void> createUser(@RequestBody UserCreateDto userCreateDto) {
        this.userService.create(userCreateDto);
        return ResponseEntity.status(201).build();
    }
}
