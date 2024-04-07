package com.example.hospitalrecords.anamnesis.service;

import com.example.hospitalrecords.anamnesis.repository.AnamnesisRepository;
import org.springframework.stereotype.Service;

@Service
public class AnamnesisService {

    private final AnamnesisRepository anamnesisRepository;

    public AnamnesisService(AnamnesisRepository anamnesisRepository){
        this.anamnesisRepository = anamnesisRepository;
    }
}
