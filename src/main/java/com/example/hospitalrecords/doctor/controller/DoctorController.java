package com.example.hospitalrecords.doctor.controller;

import com.example.hospitalrecords.doctor.model.Doctor;
import com.example.hospitalrecords.doctor.repository.DoctorRepository;
import com.example.hospitalrecords.doctor.service.DoctorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }

    @GetMapping
    public String welcome(){
        return "This is listing of our doctors";
    }

    @PostMapping
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
