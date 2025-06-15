package com.calabrowsers.api.controller;

import com.calabrowsers.api.dto.PsychologistsDTO;
import com.calabrowsers.api.model.PsychologistsModel;
import com.calabrowsers.api.service.PsychologistsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "")
    public ResponseEntity<List<PsychologistsModel>> listAllPsychologists() {

        List<PsychologistsModel> listPsychologists = service.listAllPsychologists();

        return ResponseEntity.ok(listPsychologists);
    }

    @DeleteMapping(value = "/{psychologistId}")
    public ResponseEntity<Void> deletePsychologists(@PathVariable Integer psychologistId) {

        service.deletePsychologists(psychologistId);
        return ResponseEntity.ok().build();
    }
}