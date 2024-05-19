package com.example.hospitalrecords.doctor.controller;

import com.example.hospitalrecords.doctor.dto.DoctorDto;
import com.example.hospitalrecords.doctor.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/view-doctors")
public class LandingPageDoctorController {

    private final DoctorService doctorService;
    @GetMapping("/{id}")
    public DoctorDto getDoctor(@PathVariable Long id){
        return doctorService.getDoctor(id);
    }

    @GetMapping
    public List<DoctorDto> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @GetMapping("/department/{id}")
    public List<DoctorDto> getDoctorsFromDepartment(@PathVariable Long id){
        return doctorService.getDoctorsFromDepartment(id);
    }
}
