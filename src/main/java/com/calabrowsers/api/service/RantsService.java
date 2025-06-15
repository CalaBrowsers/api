package com.calabrowsers.api.service;

import com.calabrowsers.api.dto.RantsRequestDto;
import com.calabrowsers.api.model.RantsModel;
import com.calabrowsers.api.repository.RantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RantsService {

    @Autowired
    private RantsRepository rantsRepository;

    public void create(RantsRequestDto rantsDto) {
        RantsModel rantModel = new RantsModel(rantsDto);
        this.rantsRepository.save(rantModel);
    }


}
