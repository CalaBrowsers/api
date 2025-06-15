package com.calabrowsers.api.service;

import com.calabrowsers.api.dto.RantsRequestDto;
import com.calabrowsers.api.dto.RantsResponseDto;
import com.calabrowsers.api.dto.ReactionCountDTO;
import com.calabrowsers.api.dto.RantReactionsRequestDto;
import com.calabrowsers.api.model.RantReactionsModel;
import com.calabrowsers.api.model.RantsModel;
import com.calabrowsers.api.model.ReactionModel;
import com.calabrowsers.api.repository.RantsReactionRepository;
import com.calabrowsers.api.repository.RantsRepository;
import com.calabrowsers.api.repository.ReactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RantsService {

    @Autowired
    private RantsRepository rantsRepository;

    @Autowired
    private RantsReactionRepository rantsReactionRepository;

    @Autowired
    private ReactionsRepository reactionsRepository;


    public void create(RantsRequestDto rantsDto) {
        RantsModel rantModel = new RantsModel(rantsDto);
        this.rantsRepository.save(rantModel);
    }

    public List<RantsResponseDto> listAllRants() {
        List<RantsModel> rants = this.rantsRepository.findAll();

        List<RantsResponseDto> result = new ArrayList<>();

        for (RantsModel rant : rants) {
            List<Object[]> reactionCounts =
                    rantsReactionRepository.countByRantIdGrouped(rant.getId());

            List<ReactionCountDTO> listReactionCountDTO = new ArrayList<>();

            for (Object[] row : reactionCounts) {
                Integer reactionId = (Integer) row[0];

                Long quantity = (Long) row[1];
                listReactionCountDTO.add(new ReactionCountDTO(reactionId, quantity));
            }

            result.add(new RantsResponseDto(
                    rant.getId(),
                    rant.getUserId(),
                    rant.getDescription(),
                    listReactionCountDTO
            ));
        }
        return result;
    }

    public List<ReactionModel> listAllReactions() {
        return this.reactionsRepository.findAll();
    }

    public List<RantsResponseDto> setRentReactions(RantReactionsRequestDto rantReactionsRequestDto) {
        this.rantsReactionRepository.save(new RantReactionsModel(rantReactionsRequestDto));
        return listAllRants();
    }
}
