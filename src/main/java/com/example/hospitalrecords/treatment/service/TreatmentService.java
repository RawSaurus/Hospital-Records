package com.example.hospitalrecords.treatment.service;

import com.example.hospitalrecords.patient.model.Patient;
import com.example.hospitalrecords.patient.repository.PatientRepository;
import com.example.hospitalrecords.test.dto.TestDto;
import com.example.hospitalrecords.test.model.Test;
import com.example.hospitalrecords.treatment.dto.TreatmentDto;
import com.example.hospitalrecords.treatment.mapper.TreatmentMapper;
import com.example.hospitalrecords.treatment.model.Treatment;
import com.example.hospitalrecords.treatment.repository.TreatmentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TreatmentService {

    private final TreatmentRepository treatmentRepository;
    private final PatientRepository patientRepository;
    private final TreatmentMapper treatmentMapper;

    public TreatmentDto getTreatment(Long id, String treatmentType){
        return   treatmentMapper.toTreatmentDto(patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found"))
                .getTreatments()
                .stream()
                .filter((Treatment treatment) -> treatment.getTreatmentType().equals(treatmentType))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Test not found")));
    }

    public List<TreatmentDto> getAllTreatments(Long id){
        return patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found"))
                .getTreatments()
                .stream()
                .map(treatmentMapper::toTreatmentDto)
                .collect(Collectors.toList());
    }

    public void postTreatment(Long id, TreatmentDto treatmentDto){
        Treatment treatment = treatmentMapper.toEntity(treatmentDto);
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found"));
        patient.getTreatments().add(treatment);
        patientRepository.save(patient);
    }

    public void updateTreatment(Long id, String treatmentType, TreatmentDto treatmentDto){

    }

    public void deleteTreatment(Long id){

    }
}
