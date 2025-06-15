package com.calabrowsers.api.service;

import com.calabrowsers.api.dto.LoginDTO;
import com.calabrowsers.api.dto.TokenResponseDTO;
import com.calabrowsers.api.model.UserModel;
import com.calabrowsers.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    @Lazy
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    public TokenResponseDTO login(LoginDTO data) {

        try {
            var emailPassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
            var auth = this.authenticationManager.authenticate(emailPassword);

            var token = tokenService.generateToken((UserModel) auth.getPrincipal());

            return new TokenResponseDTO(token);
        } catch (BadCredentialsException ex) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserModel user = userRepository.findByEmail(email).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
        return user;
    }
}
