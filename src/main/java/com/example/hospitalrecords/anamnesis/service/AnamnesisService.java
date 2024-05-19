package com.example.hospitalrecords.anamnesis.service;

import com.example.hospitalrecords.anamnesis.model.Anamnesis;
import com.example.hospitalrecords.anamnesis.repository.AnamnesisRepository;
import com.example.hospitalrecords.patient.model.Patient;
import com.example.hospitalrecords.patient.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Transient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AnamnesisService {

    private final AnamnesisRepository anamnesisRepository;
    private final PatientRepository patientRepository;

    public Anamnesis getAnamnesis(Long id){
       Patient patient = patientRepository.findById(id)
               .orElseThrow(() -> new EntityNotFoundException("Patient not found"));
       return patient.getAnamnesis();
    }

    public Anamnesis postAnamnesis(Long id, Anamnesis anamnesis){//TODO dto
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found"));
        anamnesis.setPatient(patient);
        anamnesisRepository.save(anamnesis);
        patient.setAnamnesis(anamnesis);
        patientRepository.save(patient);
        return anamnesis;//todo Validation - one to one - duplicate key
    }

    public Anamnesis updateAnamnesis(Long id, Anamnesis anamnesis){
        //TODO plan out
        return anamnesis;
    }

    public ResponseEntity deleteAnamnesis(Long id){
        Anamnesis deletedAnamnesis = patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found"))
                .getAnamnesis();

        anamnesisRepository.delete(deletedAnamnesis);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
