package com.example.hospitalrecords.patient.service;

import com.example.hospitalrecords.patient.dto.PatientRequestDto;
import com.example.hospitalrecords.patient.dto.PatientResponseDto;
import com.example.hospitalrecords.patient.mapper.PatientMapper;
import com.example.hospitalrecords.patient.mapper.PatientMapper2;
import com.example.hospitalrecords.patient.model.Patient;
import com.example.hospitalrecords.patient.repository.PatientRepository;
import com.example.hospitalrecords.role.model.RoleType;
import com.example.hospitalrecords.validation.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper2 patientMapper;
    private final ObjectsValidator validator;


    public PatientRequestDto getPatient(String name){
        int blank = name.indexOf(" ");
        String firstname = name.substring(0, blank);
        String lastname = name.substring(blank + 1);
        Patient patient = patientRepository.findByLastnameOrFirstname(lastname, firstname);
        return patientMapper.toRequestDto(patient);
    }

    public List<PatientRequestDto> getAllPatients(){
        return patientRepository.findAll()
                .stream()
                .map(patientMapper::toRequestDto)
                .collect(Collectors.toList());
    }

    public String savePatient(PatientRequestDto patient){
        Patient savePatient = patientMapper.toEntityFromRequest(patient);
        savePatient.setRoleType(RoleType.PATIENT);
        patientRepository.save(savePatient);
        return savePatient.toString();
    }

    public ResponseEntity updatePatientById(Long id, PatientRequestDto patient){

        Patient updatedPatient = patientRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Patient Not Found"));

        updatedPatient.setFirstname(patient.firstname());
        updatedPatient.setLastname(patient.lastname());
        updatedPatient.setAge(patient.age());
        updatedPatient.setSex(patient.sex());
        updatedPatient.setEmail(patient.email());
        updatedPatient.setWeight(patient.weight());
        updatedPatient.setHeight(patient.height());

        patientRepository.save(updatedPatient);

        return ResponseEntity.ok("patient updated");
    }

    public ResponseEntity deletePatientById(Long id){
        Patient deletedPatient = patientRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Patient Not Found"));

        patientRepository.delete(deletedPatient);
        return ResponseEntity.ok("Patient deleted");
    }
}
