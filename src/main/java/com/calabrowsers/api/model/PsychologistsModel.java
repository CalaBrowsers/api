package com.calabrowsers.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "psychologists")
public class PsychologistsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String cpf;

    private String crp;

    private String phone;

    private String email;

    private String password;

    @Column(name = "profile_photo")
    private String profilePhoto;

    private String specialty;

    @Column(name = "city_id")
    private Integer citiId;
}
