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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TreatmentService {//works

    private final TreatmentRepository treatmentRepository;
    private final PatientRepository patientRepository;
    private final TreatmentMapper treatmentMapper;

    public TreatmentDto getTreatment(Long id, Long treatmentId){
        return   treatmentMapper.toTreatmentDto(patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found"))
                .getTreatments()
                .stream()
                .filter((Treatment treatment) -> treatment.getTreatmentId().equals(treatmentId))
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

    public ResponseEntity postTreatment(Long id, TreatmentDto treatmentDto){
        Treatment treatment = treatmentMapper.toEntity(treatmentDto);
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found"));
//        treatment.setPatient(patient);
        patient.getTreatments().add(treatment);
        patientRepository.save(patient);

        return ResponseEntity.ok("Treatment saved");
    }

    public ResponseEntity updateTreatment(Long id, Long treatmentId, TreatmentDto treatmentDto){

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found"));

        for(int i = 0; i<patient.getTreatments().size(); i++){
            if(patient.getTreatments().get(i).getTreatmentId().equals(treatmentId)) {
                treatmentMapper.updateToEntity(treatmentDto, patient.getTreatments().get(i));
                patientRepository.save(patient);
                break;
            }
        }
        return ResponseEntity.ok("Treatment updated");
    }

    public ResponseEntity deleteTreatment(Long id, Long treatmentId){

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found"));

        for(int i = 0; i<patient.getTreatments().size(); i++){
            if(patient.getTreatments().get(i).getTreatmentId().equals(treatmentId)) {
                patient.getTreatments().remove(i);
                patientRepository.save(patient);
                treatmentRepository.deleteById(treatmentId);
                break;
            }
        }
        return ResponseEntity.ok("Treatment deleted");
    }
}
