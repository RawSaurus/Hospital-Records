package com.example.hospitalrecords.doctor.controller;

import com.example.hospitalrecords.doctor.model.Doctor;
import com.example.hospitalrecords.doctor.repository.DoctorRepository;
import com.example.hospitalrecords.doctor.service.DoctorService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }

    @GetMapping("/{id}")
    public Doctor getDoctor(@PathVariable Long id){
        return doctorService.getDoctor(id);
    }

    @GetMapping
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @GetMapping("/department/{id}")
    public List<Doctor> getDoctorsFromDepartment(@PathVariable Long id){
        return doctorService.getDoctorsFromDepartment(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin:create')")
    public Doctor postDoctor(@RequestBody Doctor doctor){
        return doctorService.saveDoctor(doctor);
    }

    @PutMapping("/{id}")
    public Doctor updateDoctorById(@PathVariable Long id, @RequestBody Doctor doctor){
        return doctorService.updateDoctorById(id, doctor);
    }

    @DeleteMapping("/{id}")
    public String deleteDoctorById(@PathVariable Long id){
        return doctorService.deleteDoctorById(id);
    }

}
