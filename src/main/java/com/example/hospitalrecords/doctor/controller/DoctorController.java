package com.example.hospitalrecords.controller;

import com.example.hospitalrecords.model.Doctor;
import com.example.hospitalrecords.repository.DoctorRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private DoctorRepository doctorRepository;

    public DoctorController(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }

    @GetMapping
    public String welcome(){
        return "This is listing of our doctors";
    }

    @PostMapping
    public Doctor postDoctor(@RequestBody Doctor doctor){
        return doctorRepository.save(doctor);
    }

    @PutMapping("/{id}")
    public Doctor updateDoctorById(@PathVariable Long id, @RequestBody Doctor doctor){
        Doctor updatedDoctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor Not Found"));

        updatedDoctor.setName(doctor.getName());
        updatedDoctor.setSurname(doctor.getSurname());
        updatedDoctor.setTitle(doctor.getTitle());

        return doctorRepository.save(updatedDoctor);
    }

    @DeleteMapping("/{id}")
    public String deleteDoctorById(@PathVariable Long id){
        if(doctorRepository.existsById(id)){
            doctorRepository.deleteById(id);
            return "Doctor deleted successfully";
        }
        else
            throw new RuntimeException("Doctor Not Found");
    }

}
