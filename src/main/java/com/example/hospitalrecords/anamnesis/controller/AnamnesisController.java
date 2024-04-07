package com.example.hospitalrecords.anamnesis.controller;

import com.example.hospitalrecords.anamnesis.service.AnamnesisService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/anamnesis")
public class AnamnesisController {


    private final AnamnesisService anamnesisService;

    public AnamnesisController(AnamnesisService anamnesisService){
        this.anamnesisService = anamnesisService;
    }
}
