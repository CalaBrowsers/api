package com.calabrowsers.api.controller;

import com.calabrowsers.api.dto.RantReactionsRequestDto;
import com.calabrowsers.api.dto.RantsRequestDto;
import com.calabrowsers.api.dto.RantsResponseDto;
import com.calabrowsers.api.model.ReactionModel;
import com.calabrowsers.api.service.RantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping()
    public ResponseEntity<List<RantsResponseDto>> listAllRants() {
        List<RantsResponseDto> response = this.rantsService.listAllRants();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/reaction")
    public ResponseEntity<List<ReactionModel>> listAllReactions() {
        List<ReactionModel> response = this.rantsService.listAllReactions();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/set-reaction")
    public ResponseEntity<List<RantsResponseDto>> setRentReactions(@RequestBody RantReactionsRequestDto rantReactionsRequestDto) {
        List<RantsResponseDto> response = this.rantsService.setRentReactions(rantReactionsRequestDto);
        return ResponseEntity.ok(response);
    }

}
