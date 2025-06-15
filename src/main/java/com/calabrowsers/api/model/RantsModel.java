package com.calabrowsers.api.model;

import com.calabrowsers.api.dto.RantsRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "rants")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RantsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    private Integer userId;

    private Integer reportCount;

    private String description;

    public RantsModel(RantsRequestDto dto) {
        this.userId = dto.userId();
        this.createdAt = LocalDateTime.now();
        this.description = dto.description();
        this.reportCount = 0;
    }
}
