package com.example.hospitalrecords.patient.mapper;

import com.example.hospitalrecords.patient.dto.PatientRequestDto;
import com.example.hospitalrecords.patient.dto.PatientResponseDto;
import com.example.hospitalrecords.patient.model.Patient;
import org.springframework.stereotype.Service;

@Service
public class PatientMapper {

    public Patient toPatient(PatientRequestDto patientRequestDto){
       Patient patient = new Patient();

       patient.setFirstName(patientRequestDto.firstName());
       patient.setLastName(patientRequestDto.lastName());
       patient.setAge(patientRequestDto.age());
       patient.setEmail(patientRequestDto.email());

       return patient;
    }

    public PatientRequestDto patientRequestDto(Patient patient){
        return new PatientRequestDto(
                patient.getFirstName(),
                patient.getLastName(),
                patient.getAge(),
                patient.getEmail()
        );
    }
    public PatientResponseDto toResponseDto(Patient patient){
        return new PatientResponseDto(
                patient.getFirstName(),
                patient.getLastName());
    }
}
