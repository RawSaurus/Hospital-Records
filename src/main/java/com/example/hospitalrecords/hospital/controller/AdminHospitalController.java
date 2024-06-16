package com.example.hospitalrecords.hospital.controller;

import com.example.hospitalrecords.hospital.dto.HospitalDto;
import com.example.hospitalrecords.hospital.dto.HospitalInfoDto;
import com.example.hospitalrecords.hospital.model.Hospital;
import com.example.hospitalrecords.hospital.model.HospitalInfo;
import com.example.hospitalrecords.hospital.repository.HospitalRepository;
import com.example.hospitalrecords.hospital.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/hospitals")
@RequiredArgsConstructor
public class AdminHospitalController {

    private final HospitalService hospitalService;

    @PostMapping()
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity postHospital(@RequestBody HospitalDto hospitalDto){
        return hospitalService.saveHospital(hospitalDto);
    }
    @PostMapping("/{name}")
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity postHospitalInfo(@PathVariable String name, @RequestBody HospitalInfoDto hospitalInfoDto){
        return hospitalService.postHospitalInfo(name, hospitalInfoDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:update')")
    public ResponseEntity updateHospital(@PathVariable Long id, @RequestBody HospitalDto hospitalDto){
        return hospitalService.updateHospital(id, hospitalDto);
    }

    @PutMapping("/{id}/info")
    @PreAuthorize("hasAuthority('admin:update')")
    public ResponseEntity updateHospitalInfo(@PathVariable Long id, @RequestBody HospitalInfoDto hospitalInfoDto) {
        return hospitalService.updateHospitalInfo(id, hospitalInfoDto);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public ResponseEntity deleteHospital(@PathVariable Long id){
        return hospitalService.deleteHospital(id);
    }
}

