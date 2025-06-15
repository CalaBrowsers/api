package com.calabrowsers.api.model;

import com.calabrowsers.api.dto.RantReactionsRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rants_reactions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RantReactionsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer rantId;

    private Integer reactionId;

    public RantReactionsModel(RantReactionsRequestDto rantReactionsRequestDto) {
        this.rantId = rantReactionsRequestDto.rantId();
        this.reactionId = rantReactionsRequestDto.reactionId();
    }
}
