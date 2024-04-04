package com.example.hospitalrecords.doctor.service;

import com.example.hospitalrecords.doctor.model.Doctor;
import com.example.hospitalrecords.doctor.repository.DoctorRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * Service is injected with dependency to repository
 * Service is injected into controller as dependency
 * Is used to create logic, fetching, manipulating data between endpoints and database
 * */
@Service
public class DoctorService {

    /**Dependency injection*/
    private final DoctorRepository doctorRepository;

    /**RequiredArgsConstructor*/
    public DoctorService(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }

    /**Creates new Doctor
     * 'save' method returns entity specified in repository
     * */
    public Doctor saveDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    /**Updating existing doctor, changes attributes, ID stays same*/
    public Doctor updateDoctorById(Long id, Doctor doctor){

        /**First find doctor by id and save to variable, if id doesn't exit throw exception(should create custom ones later)*/
        Doctor updatedDoctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor Not Found"));

        /**Update fields via setters of existing doctor and getters of new doctor data from method parameters
         * */
        updatedDoctor.setName(doctor.getName());
        updatedDoctor.setSurname(doctor.getSurname());
        updatedDoctor.setTitle(doctor.getTitle());

        return doctorRepository.save(updatedDoctor);
    }

    public String deleteDoctorById(Long id){

        Doctor deletedDoctor = doctorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Doctor Not Found"));
        return "Doctor deleted successfully";
    }

}
