package com.example.hospitalrecords.treatment.controller;

import com.example.hospitalrecords.treatment.service.TreatmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/treatments")
public class TreatmentController {

    private final TreatmentService treatmentService;

    public TreatmentController(TreatmentService treatmentService){
        this.treatmentService = treatmentService;
    }
}
