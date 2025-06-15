package com.calabrowsers.api.dto;

public record PsychologistsDTO(

        String name,

        String cpf,

        String crp,

        String phone,

        String email,

        String password,

        String profilePhoto,

        String specialty,

        Integer cityId
) {
}
