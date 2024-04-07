package com.example.hospitalrecords.treatment.service;

import com.example.hospitalrecords.treatment.repository.TreatmentRepository;
import org.springframework.stereotype.Service;

@Service
public class TreatmentService {

    private final TreatmentRepository treatmentRepository;

    public TreatmentService(TreatmentRepository treatmentRepository){
        this.treatmentRepository = treatmentRepository;
    }
}
