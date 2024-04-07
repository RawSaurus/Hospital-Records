package com.example.hospitalrecords.patient.service;

import com.example.hospitalrecords.patient.mapper.PatientMapper;
import com.example.hospitalrecords.patient.model.Patient;
import com.example.hospitalrecords.patient.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public PatientService(PatientRepository patientRepository, PatientMapper patientMapper){
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    public Patient savePatient(Patient patient){
        return patientRepository.save(patient);
    }

    public Patient updatePatientById(Long id, Patient patient){

        Patient updatedPatient = patientRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Patient Not Found"));


        updatedPatient.setFirstName(patient.getFirstName());
        updatedPatient.setLastName(patient.getLastName());
        updatedPatient.setAge(patient.getAge());
        updatedPatient.setSex(patient.getSex());
        updatedPatient.setEmail(patient.getEmail());
        updatedPatient.setWeight(patient.getWeight());
        updatedPatient.setHeight(patient.getHeight());

        return patientRepository.save(updatedPatient);
    }

    public String deletePatientById(Long id){
        Patient deletedPatient = patientRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Patient Not Found"));

        return "Patient deleted successfully";
    }
}
