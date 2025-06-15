package com.calabrowsers.api.service;

import com.calabrowsers.api.dto.UserCreateDto;
import com.calabrowsers.api.model.UserModel;
import com.calabrowsers.api.repository.NickNameRepository;
import com.calabrowsers.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NickNameRepository nickNameRepository;

    public void create(UserCreateDto dto){
        String hashedPassword = "";

        if(dto.password() != null){
            System.out.printf(dto.password());
            hashedPassword = new BCryptPasswordEncoder().encode(dto.password());
            userRepository.save(new UserModel(dto, hashedPassword, generateNickName()));
            return;
        }

        hashedPassword = new BCryptPasswordEncoder().encode(dto.cpf());
        UserModel newUser = new UserModel(dto, hashedPassword, generateNickName());
        newUser.setYoung(false);
        userRepository.save(newUser);
    }


    private String generateNickName() {
        String base = nickNameRepository.findNicknameRandom().orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
        String suffix = UUID.randomUUID().toString().replace("-", "").substring(0, 6);

        return base + "-" + suffix;
    }
}
