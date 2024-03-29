package com.example.hospitalrecords.controller;

import com.example.hospitalrecords.model.Hospital;
import com.example.hospitalrecords.repository.HospitalRepository;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class HospitalController {

    private HospitalRepository hospitalRepository;

    public HospitalController(HospitalRepository hospitalRepository){
       this.hospitalRepository = hospitalRepository;
    }

    @GetMapping("/hospital")
    public String welcome(){
        return "Welcome in da Hospital";
    }

    //not working
    @GetMapping("/Hospitals/{id}")
    public String getHospital(@PathVariable Long id){
        Hospital getHospital = hospitalRepository.getReferenceById(id);
        return getHospital.toString();
    }

    @PostMapping("/hospitals")
    public Hospital postHospital(@RequestBody Hospital hospital){
        return hospitalRepository.save(hospital);
    }

    @PutMapping("hospitals/{id}")
    public Hospital updateHospital(@PathVariable Long id, @RequestBody Hospital hospital){
       Hospital updateHospital = hospitalRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Hospital Not Found"));

       updateHospital.setName(hospital.getName());

       return hospitalRepository.save(updateHospital);
    }

    @DeleteMapping("hospitals/{id}")
    public String deleteHospital(@PathVariable Long id){
        if(hospitalRepository.existsById(id)) {
            hospitalRepository.deleteById(id);
            return "Hospital deleted successfully";
        }
        else
            throw new RuntimeException("Hospital Not Found");
    }
}
