package com.calabrowsers.api.model;

import com.calabrowsers.api.dto.UserRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserModel implements UserDetails {

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

    public UserModel(UserRequestDto dto, String hashedPassword, String nickName) {
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return email;
    }
}
