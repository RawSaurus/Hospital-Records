package com.example.hospitalrecords.patient.mapper;

import com.example.hospitalrecords.patient.dto.PatientRequestDto;
import com.example.hospitalrecords.patient.model.Patient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class PatientMapper2 {

    public PatientRequestDto toRequestDto(Patient patient){
        if(patient==null)
            return null;

        return new PatientRequestDto(
                patient.getFirstname(),
                patient.getLastname(),
                patient.getAge(),
                patient.getEmail(),
                patient.getSex(),
                patient.getHeight(),
                patient.getWeight(),
                patient.getContact()
        );
    }

    public Patient toEntityFromRequest(PatientRequestDto patientRequestDto){
        if(patientRequestDto==null)
            return null;

        Patient patient = new Patient();

        patient.setFirstname(patientRequestDto.firstname());
        patient.setLastname(patientRequestDto.lastname());
        patient.setAge(patientRequestDto.age());
        patient.setEmail(patientRequestDto.email());
        patient.setSex(patientRequestDto.sex());
        patient.setHeight(patientRequestDto.height());
        patient.setWeight(patientRequestDto.weight());
        patient.setContact(patientRequestDto.contact());

        return patient;
    }

}
