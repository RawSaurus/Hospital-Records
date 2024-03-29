package com.example.hospitalrecords.controller;

import com.example.hospitalrecords.model.Patient;
import com.example.hospitalrecords.repository.PatientRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    @PostMapping
    public Patient postPatient(@RequestBody Patient patient){
        return patientRepository.save(patient);
    }

    @PutMapping("/{id}")
    public Patient updatePatientById(@PathVariable Long id, @RequestBody Patient patient){
        Patient updatedPatient = patientRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Patient Not Found"));

        updatedPatient.setFirstName(patient.getFirstName());
        updatedPatient.setLastName(patient.getLastName());
        updatedPatient.setAge(patient.getAge());
        updatedPatient.setSex(patient.getSex());
        updatedPatient.setEmail(patient.getEmail());
        updatedPatient.setWeight(patient.getWeight());
        updatedPatient.setHeight(patient.getHeight());

        return patientRepository.save(updatedPatient);
    }

    @DeleteMapping("/{id}")
    public String deletePatientById(@PathVariable Long id){
        if(patientRepository.existsById(id)){
            patientRepository.deleteById(id);
            return "Patient deleted successfuly";
        }
        else
            throw new RuntimeException("Patient Not Found");
    }
}
