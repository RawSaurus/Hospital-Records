package com.example.hospitalrecords.patient.controller;

import com.example.hospitalrecords.patient.dto.PatientRequestDto;
import com.example.hospitalrecords.patient.dto.PatientResponseDto;
import com.example.hospitalrecords.patient.model.Patient;
import com.example.hospitalrecords.patient.service.PatientService;
import com.example.hospitalrecords.role.model.RoleType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/{name}")
    @PreAuthorize("hasAuthority('admin:read')")
    public PatientRequestDto getPatient(@PathVariable String name){
        return patientService.getPatient(name);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('admin:read')")
    public List<PatientRequestDto> getAllPatients(){
        return patientService.getAllPatients();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin:create')")
    public String postPatient(@RequestBody PatientRequestDto patient){
        return patientService.savePatient(patient);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:update')")
    public ResponseEntity updatePatientById(@PathVariable Long id, @RequestBody PatientRequestDto patient){
        return patientService.updatePatientById(id, patient);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public ResponseEntity deletePatientById(@PathVariable Long id){
        return patientService.deletePatientById(id);
    }
}
