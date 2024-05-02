package com.example.hospitalrecords.patient.controller;

import com.example.hospitalrecords.patient.model.Patient;
import com.example.hospitalrecords.patient.service.PatientService;
import com.example.hospitalrecords.patient.service.PatientService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @GetMapping("/{name}")
    @PreAuthorize("hasAuthority('admin:read')")
    public Patient getPatient(@PathVariable String name){
        return patientService.getPatient(name);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('admin:read')")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin:create')")
    public Patient postPatient(@RequestBody Patient patient){
        return patientService.savePatient(patient);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:update')")
    public Patient updatePatientById(@PathVariable Long id, @RequestBody Patient patient){
        return patientService.updatePatientById(id, patient);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public String deletePatientById(@PathVariable Long id){
        return patientService.deletePatientById(id);
    }
}
