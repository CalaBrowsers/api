package com.calabrowsers.api.controller;

import com.calabrowsers.api.dto.RantsRequestDto;
import com.calabrowsers.api.service.RantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/rants")
public class RantsController {

    @Autowired
    private RantsService rantsService;

    @PostMapping()
    public ResponseEntity<Void> createRants(@RequestBody RantsRequestDto rantsRequestDto) {
        this.rantsService.create(rantsRequestDto);
        return ResponseEntity.status(201).build();
    }
}
