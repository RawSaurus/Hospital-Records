package com.example.hospitalrecords.patient.service;

import com.example.hospitalrecords.patient.dto.PatientRequestDto;
import com.example.hospitalrecords.patient.dto.PatientResponseDto;
import com.example.hospitalrecords.patient.mapper.PatientMapper;
import com.example.hospitalrecords.patient.mapper.PatientMapper2;
import com.example.hospitalrecords.patient.model.Patient;
import com.example.hospitalrecords.patient.repository.PatientRepository;
import com.example.hospitalrecords.role.model.RoleType;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper2 patientMapper;


    public PatientRequestDto getPatient(String name){
        System.out.println(name);
        int blank = name.indexOf(" ");
        System.out.println(blank);
        String firstname = name.substring(0, blank);
        String lastname = name.substring(blank + 1);
        System.out.println(firstname);
        System.out.println(lastname);
        Patient patient = patientRepository.findByLastnameOrFirstname(lastname, firstname);
        return patientMapper.toRequestDto(patient);
    }

    public List<Patient> getAllPatients(){//TODO dto
       return patientRepository.findAll();
    }

    public void savePatient(PatientRequestDto patient){
        Patient savePatient = patientMapper.toEntityFromRequest(patient);
        savePatient.setRoleType(RoleType.PATIENT);
        patientRepository.save(savePatient);
    }

    public PatientRequestDto updatePatientById(Long id, PatientRequestDto patient){//TODO not working correctly

        Patient updatedPatient = patientRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Patient Not Found"));

        updatedPatient = patientMapper.toEntityFromRequest(patient);
//        updatedPatient.setFirstname(patient.firstname());
//        updatedPatient.setLastname(patient.lastname());
//        updatedPatient.setAge(patient.age());
//        updatedPatient.setSex(patient.sex());
//        updatedPatient.setEmail(patient.email());
//        updatedPatient.setWeight(patient.weight());
//        updatedPatient.setHeight(patient.height());

        patientRepository.save(updatedPatient);

        return patientMapper.toRequestDto(updatedPatient);
    }

    public void deletePatientById(Long id){
        Patient deletedPatient = patientRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Patient Not Found"));

        patientRepository.delete(deletedPatient);
    }
}
