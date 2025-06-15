package com.calabrowsers.api.controller;

import com.calabrowsers.api.dto.UserRequestDto;
import com.calabrowsers.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<Void> createUser(@RequestBody UserRequestDto userRequestDto) {
        this.userService.create(userRequestDto);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Integer> createUser(@PathVariable("id") Integer id,
                                           @RequestBody UserRequestDto userRequestDto) {
        this.userService.update(id, userRequestDto);
        return ResponseEntity.ok(1);

    }
}
