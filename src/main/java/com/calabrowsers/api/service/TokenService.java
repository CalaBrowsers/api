package com.calabrowsers.api.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.calabrowsers.api.model.UserModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(UserModel userModel) {

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("elumini")
                    .withSubject(userModel.getEmail())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException ex) {
            throw new RuntimeException("Error while generating token" + ex);
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("elumini")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (TokenExpiredException ex) {
            throw new TokenExpiredException(ex.getMessage(), ex.getExpiredOn());
        } catch (JWTVerificationException ex){
            return "";
        }
    }
}
