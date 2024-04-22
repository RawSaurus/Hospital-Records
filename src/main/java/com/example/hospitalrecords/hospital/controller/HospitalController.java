package com.example.hospitalrecords.hospital.controller;

import com.example.hospitalrecords.hospital.dto.HospitalContactsDto;
import com.example.hospitalrecords.hospital.model.HospitalInfo;
import com.example.hospitalrecords.hospital.service.HospitalService;
import com.example.hospitalrecords.department.model.Department;
import com.example.hospitalrecords.hospital.model.Hospital;
import com.example.hospitalrecords.role.model.RoleType;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/hospitals")
@PreAuthorize("hasRole('ADMIN')")
public class HospitalController {

    private final HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(){
        return ResponseEntity.ok("hello");
    }

    @GetMapping("/description/{id}")
    public ResponseEntity<String> getHospitalDescription(@PathVariable Long id){
        return ResponseEntity.ok(hospitalService.findById(id).toString());
    }

    @GetMapping("/{id}")
    public Hospital getHospital(@PathVariable Long id){
        return hospitalService.findById(id);
    }

   @GetMapping("/{id}/hospital-info")
    public HospitalInfo getHospitalInfo(@PathVariable Long id){
        return hospitalService.findById(id).getHospitalInfo();
    }

    @GetMapping("/{id}/hospital-contacts")
    public HospitalContactsDto getContacts(@PathVariable Long id){
        return hospitalService.findContactsByHospitalId(id);
    }

    @GetMapping()
    public List<Hospital> findAllHospitals(){
        return hospitalService.findAll();
    }
}
