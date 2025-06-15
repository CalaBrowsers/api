package com.calabrowsers.api.controller;

import com.calabrowsers.api.dto.LoginDTO;
import com.calabrowsers.api.dto.TokenResponseDTO;
import com.calabrowsers.api.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> login(@RequestBody LoginDTO loginDTO) {
        TokenResponseDTO tokenResponseDTO = this.authService.login(loginDTO);
        return ResponseEntity.ok(tokenResponseDTO);
    }
}
