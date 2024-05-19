package com.example.hospitalrecords.doctor.controller;

import com.example.hospitalrecords.doctor.dto.DoctorDto;
import com.example.hospitalrecords.doctor.model.Doctor;
import com.example.hospitalrecords.doctor.repository.DoctorRepository;
import com.example.hospitalrecords.doctor.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;


    @PostMapping
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity postDoctor(@RequestBody DoctorDto doctor){
        return doctorService.saveDoctor(doctor);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:update')")
    public ResponseEntity updateDoctorById(@PathVariable Long id, @RequestBody DoctorDto doctor){
        return doctorService.updateDoctorById(id, doctor);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public ResponseEntity deleteDoctorById(@PathVariable Long id){
        return doctorService.deleteDoctorById(id);
    }

}
