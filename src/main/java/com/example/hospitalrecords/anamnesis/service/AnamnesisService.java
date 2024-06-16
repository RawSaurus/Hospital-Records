package com.example.hospitalrecords.anamnesis.service;

import com.example.hospitalrecords.anamnesis.dto.AnamnesisRequestDto;
import com.example.hospitalrecords.anamnesis.mapper.AnamnesisMapper;
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
public class AnamnesisService {//works

    private final AnamnesisRepository anamnesisRepository;
    private final PatientRepository patientRepository;
    private final AnamnesisMapper anamnesisMapper;

    public AnamnesisRequestDto getAnamnesis(Long id){
       Patient patient = patientRepository.findById(id)
               .orElseThrow(() -> new EntityNotFoundException("Patient not found"));
       return anamnesisMapper.toRequestDto(patient.getAnamnesis());
    }

    public ResponseEntity postAnamnesis(Long id, AnamnesisRequestDto anamnesis){
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found"));

        patient.setAnamnesis(anamnesisMapper.toEntity(anamnesis));
        patientRepository.save(patient);

        return ResponseEntity.ok("Anamnesis created");
        //todo Validation - one to one - duplicate key
    }

    public ResponseEntity updateAnamnesis(Long id, AnamnesisRequestDto dto){
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found"));

        anamnesisMapper.updateToEntity(dto, patient.getAnamnesis());

        patientRepository.save(patient);

        return ResponseEntity.ok("Anamnesis updated");
    }

    public ResponseEntity deleteAnamnesis(Long id){

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found"));

        Anamnesis deletedAnamnesis = patient
                .getAnamnesis();

        patient.setAnamnesis(null);
        patientRepository.save(patient);
        anamnesisRepository.deleteById(deletedAnamnesis.getAnamnesisId());
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
