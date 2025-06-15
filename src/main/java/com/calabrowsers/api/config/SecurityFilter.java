package com.calabrowsers.api.config;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.calabrowsers.api.repository.UserRepository;
import com.calabrowsers.api.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;


    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        var token = this.recoverToken(request);
        if (token != null) {
            try {
                var email = tokenService.validateToken(token);
                UserDetails user = userRepository.findByEmail(email).orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND));

                var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);

            } catch (TokenExpiredException ex){
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }

        }
        filterChain.doFilter(request, response);
    }

    public String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }
}
