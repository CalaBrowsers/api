package com.calabrowsers.api.model;

import com.calabrowsers.api.dto.UserCreateDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String nickname;

    private String birthdate;

    private String cpf;

    private String phone;

    private String email;

    private String password;

    @Column(name = "is_young")
    private boolean isYoung;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "city_id")
    private Integer cityId;

    public UserModel(UserCreateDto dto, String hashedPassword, String nickName) {
        this.name = dto.name();
        this.nickname = nickName;
        this.cpf = dto.cpf();
        this.birthdate = dto.birthdate();
        this.phone = dto.phone();
        this.email = dto.email();
        this.password = hashedPassword;
        this.isYoung = true;
        this.companyId = dto.companyId();
        this.cityId = dto.cityId();
    }
}
