package com.example.hospitalrecords.doctor.service;

import com.example.hospitalrecords.department.model.Department;
import com.example.hospitalrecords.department.repository.DepartmentRepository;
import com.example.hospitalrecords.doctor.model.Doctor;
import com.example.hospitalrecords.doctor.repository.DoctorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final DepartmentRepository departmentRepository;

    public Doctor getDoctor(Long id){
        return doctorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found"));
    }

    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    public List<Doctor> getDoctorsFromDepartment(Long id){
      Department department = departmentRepository.findById(id)
              .orElseThrow(() -> new EntityNotFoundException("Department not found"));

      return department.getDoctors()
              .stream()
              .toList();
    }

    public Doctor saveDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctorById(Long id, Doctor doctor){

        Doctor updatedDoctor = doctorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Doctor Not Found"));

        updatedDoctor.setFirstname(doctor.getFirstname());
        updatedDoctor.setLastname(doctor.getLastname());
        updatedDoctor.setTitle(doctor.getTitle());
        updatedDoctor.setEmail(doctor.getEmail());

        return doctorRepository.save(updatedDoctor);//TODO mapper
    }

    public String deleteDoctorById(Long id){

        Doctor deletedDoctor = doctorRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Doctor Not Found"));
        return "Doctor deleted successfully";
    }

}
