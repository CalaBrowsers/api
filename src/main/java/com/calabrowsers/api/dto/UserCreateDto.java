package com.calabrowsers.api.dto;

public record UserCreateDto(
        String name,

        String cpf,

        String birthdate,

        String email,

        String phone,

        String password,

        Integer companyId,

        Integer cityId) {
}
