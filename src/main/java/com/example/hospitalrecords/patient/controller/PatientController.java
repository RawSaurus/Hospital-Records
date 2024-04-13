package com.example.hospitalrecords.patient.controller;

import com.example.hospitalrecords.patient.model.Patient;
import com.example.hospitalrecords.patient.service.PatientService;
import com.example.hospitalrecords.patient.service.PatientService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @PostMapping
    public Patient postPatient(@RequestBody Patient patient){
        return patientService.savePatient(patient);
    }

    @PutMapping("/{id}")
    public Patient updatePatientById(@PathVariable Long id, @RequestBody Patient patient){
        return patientService.updatePatientById(id, patient);
    }

    @DeleteMapping("/{id}")
    public String deletePatientById(@PathVariable Long id){
        return patientService.deletePatientById(id);
    }
}
