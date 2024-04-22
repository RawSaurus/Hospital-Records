package com.example.hospitalrecords.hospital.controller;

import com.example.hospitalrecords.hospital.model.Hospital;
import com.example.hospitalrecords.hospital.repository.HospitalRepository;
import com.example.hospitalrecords.hospital.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/hospitals")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
public class AdminHospitalController {

    private final HospitalService hospitalService;

    @PostMapping()
    @PreAuthorize("hasAuthority('admin:create')")
    public Hospital postHospital(@RequestBody Hospital hospital){
        return hospitalService.saveHospital(hospital);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:update')")
    public Hospital updateHospital(@PathVariable Long id, @RequestBody Hospital hospital){
        return hospitalService.updateHospital(id, hospital);
    }
    @DeleteMapping("/delete-by-id/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public String deleteHospital(@PathVariable Long id){
        return hospitalService.deleteHospital(id);
    }
    @DeleteMapping("/{name}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public String deleteHospital2(@PathVariable String name){
        return hospitalService.deleteHospitalByName(name);
    }
}