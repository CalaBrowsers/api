package com.calabrowsers.api.controller;

import com.calabrowsers.api.dto.PsychologistsDTO;
import com.calabrowsers.api.service.PsychologistsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/psychologists")
public class PsychologistsController {

    @Autowired
    PsychologistsService service;

    @PostMapping(value = "")
    public ResponseEntity<Void> createPsychologists(@RequestBody PsychologistsDTO data) {

        service.createPsychologists(data);
        return ResponseEntity.status(201).build();
    }
}
