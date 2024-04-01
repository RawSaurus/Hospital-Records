package com.example.hospitalrecords.controller;

import com.example.hospitalrecords.model.Department;
import com.example.hospitalrecords.model.Hospital;
import com.example.hospitalrecords.repository.DepartmentRepository;
import com.example.hospitalrecords.repository.HospitalRepository;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HospitalController {

    private HospitalRepository hospitalRepository;
    private DepartmentRepository deptRepository;

    public HospitalController(HospitalRepository hospitalRepository, DepartmentRepository deptRepository){
       this.hospitalRepository = hospitalRepository;
       this.deptRepository = deptRepository;
    }

    @GetMapping("/hospital")
    public String welcome(){
        return "Welcome in da Hospital";
    }

    @GetMapping("/hospitals/{id}")
    public String getHospital(@PathVariable Long id){
        return hospitalRepository.getReferenceById(id).toString();
    }

    @GetMapping("/hospitals")
    public List<Hospital> findAllHospitals(){
        return hospitalRepository.findAll();
    }
    @PostMapping("/hospitals")
    public Hospital postHospital(@RequestBody Hospital hospital){
        return hospitalRepository.save(hospital);
    }

    @PutMapping("/hospitals/{id}/add-department/{dept-id}")
    public Hospital addDepartment(@PathVariable Long id, @PathVariable(name = "dept-id") Long deptId){
        Hospital hospital = hospitalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hospital Not Found"));

        Department addedDepartment = deptRepository.findById(deptId)
                .orElseThrow(() -> new RuntimeException("Department Not Found"));

        hospital.addDepartment(addedDepartment);

        return hospitalRepository.save(hospital);
    }

    @PutMapping("hospitals/{id}")
    public Hospital updateHospital(@PathVariable Long id, @RequestBody Hospital hospital){
       Hospital updateHospital = hospitalRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Hospital Not Found"));

       updateHospital.setName(hospital.getName());

       return hospitalRepository.save(updateHospital);
    }

    @DeleteMapping("hospitalsu/{id}")
    public String deleteHospital(@PathVariable Long id){
        if(hospitalRepository.existsById(id)) {
            hospitalRepository.deleteById(id);
            return "Hospital deleted successfully";
        }
        else
            throw new RuntimeException("Hospital Not Found");
    }

    @DeleteMapping("hospitals/{id}")
    public String deleteHospital2(@PathVariable Long id){
        Hospital deleteHospital = hospitalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hospital Not Found"));

        hospitalRepository.delete(deleteHospital);

        return "Hospital deleted successfully";
    }
}
