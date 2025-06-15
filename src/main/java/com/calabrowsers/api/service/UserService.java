package com.calabrowsers.api.service;

import com.calabrowsers.api.dto.UserRequestDto;
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

    public void create(UserRequestDto dtoCreate){
        String hashedPassword = "";

        if(dtoCreate.password() != null){
            System.out.printf(dtoCreate.password());
            hashedPassword = new BCryptPasswordEncoder().encode(dtoCreate.password());
            this.userRepository.save(new UserModel(dtoCreate, hashedPassword, generateNickName()));
            return;
        }

        hashedPassword = new BCryptPasswordEncoder().encode(dtoCreate.cpf());
        UserModel newUser = new UserModel(dtoCreate, hashedPassword, generateNickName());
        newUser.setYoung(false);
        this.userRepository.save(newUser);
    }

    public Integer update(Integer id, UserRequestDto dtoEdit) {
        if(id == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        UserModel userToEdit = userRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));

        userToEdit.setName((dtoEdit.name() == null || dtoEdit.name().isBlank()) ?
                userToEdit.getName() : dtoEdit.name());

        userToEdit.setCpf((dtoEdit.cpf() == null || dtoEdit.cpf().isBlank()) ?
                userToEdit.getCpf() : dtoEdit.cpf());

        userToEdit.setBirthdate((dtoEdit.birthdate() == null || dtoEdit.birthdate().isBlank()) ?
                userToEdit.getBirthdate() : dtoEdit.birthdate());

        userToEdit.setEmail((dtoEdit.email() == null || dtoEdit.email().isBlank()) ?
                userToEdit.getEmail() : dtoEdit.email());

        userToEdit.setPassword((dtoEdit.password() == null || dtoEdit.password().isBlank()) ?
                userToEdit.getPassword() : new BCryptPasswordEncoder().encode(dtoEdit.password()));

        userToEdit.setPhone((dtoEdit.phone() == null || dtoEdit.phone().isBlank()) ?
                userToEdit.getPhone() : dtoEdit.phone());

        userToEdit.setCityId((dtoEdit.cityId() == null) ?
                userToEdit.getCityId() : dtoEdit.cityId());
        System.out.println(userToEdit);

        this.userRepository.save(userToEdit);

        return userToEdit.getId();
    }

    private String generateNickName() {
        String base = nickNameRepository.findNicknameRandom().orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
        String suffix = UUID.randomUUID().toString().replace("-", "").substring(0, 6);

        return base + "-" + suffix;
    }
}
