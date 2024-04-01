package com.example.hospitalrecords.hospital.controller;

import com.example.hospitalrecords.hospital.service.HospitalService;
import com.example.hospitalrecords.department.model.Department;
import com.example.hospitalrecords.hospital.model.Hospital;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hospitals")
public class HospitalController {

    private final HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping()
    public String welcome(){
        return "Welcome in da Hospital";
    }

    @GetMapping()
    public String getHospital(@PathVariable Long id){
        return hospitalService.findById(id).toString();
    }

    @GetMapping()
    public List<Hospital> findAllHospitals(){
        return hospitalService.findAll();
    }
    @PostMapping()
    public Hospital postHospital(@RequestBody Hospital hospital){
        return hospitalService.saveHospital(hospital);
    }
    @PutMapping("/{id}")
    public Hospital updateHospital(@PathVariable Long id, @RequestBody Hospital hospital){
       return hospitalService.updateHospital(id, hospital);
    }
    @DeleteMapping("/{id}")
    public String deleteHospital2(@PathVariable Long id){
        return hospitalService.deleteHospital(id);
    }
}
