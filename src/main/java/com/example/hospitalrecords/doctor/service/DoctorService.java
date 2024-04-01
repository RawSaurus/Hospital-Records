package com.example.hospitalrecords.doctor.service;

import com.example.hospitalrecords.doctor.model.Doctor;
import com.example.hospitalrecords.doctor.repository.DoctorRepository;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }

    public Doctor saveDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctorById(Long id, Doctor doctor){

        Doctor updatedDoctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor Not Found"));

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
