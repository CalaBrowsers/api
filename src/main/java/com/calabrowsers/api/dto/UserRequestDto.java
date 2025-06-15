package com.calabrowsers.api.dto;

public record UserRequestDto(
        String name,

        String cpf,

        String birthdate,

        String email,

        String phone,

        String password,

        Integer companyId,

        Integer cityId) {
}
