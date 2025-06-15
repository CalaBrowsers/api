package com.calabrowsers.api.service;

import com.calabrowsers.api.dto.PsychologistsDTO;
import com.calabrowsers.api.model.PsychologistsModel;
import com.calabrowsers.api.repository.PsychologistsRepository;
import com.calabrowsers.api.util.ValidateCpfUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PsychologistsService {

    @Autowired
    PsychologistsRepository repository;

    @Autowired
    static ValidateCpfUtil validateCpfUtil;

    public void createPsychologists(PsychologistsDTO data) {

        if (repository.findByEmail(data.email()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "E-mail já cadastrado");
        }

        if (!validateCpfUtil.cpfValidate(data.cpf())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cpf Invalido");
        }



        PsychologistsModel psychologist = new PsychologistsModel();

        psychologist.setName(data.name());
        psychologist.setCpf(data.cpf());
        psychologist.setCrp(data.crp());
        psychologist.setPhone(data.phone());
        psychologist.setEmail(data.email());
        psychologist.setPassword(data.email());
        psychologist.setProfilePhoto(data.profilePhoto());
        psychologist.setSpecialty(data.specialty());
        psychologist.setCitiId(data.cityId());

        repository.save(psychologist);

    }



}
