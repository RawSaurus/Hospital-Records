package com.example.hospitalrecords.hospital.controller;

import com.example.hospitalrecords.hospital.dto.HospitalContactsDto;
import com.example.hospitalrecords.hospital.dto.HospitalDto;
import com.example.hospitalrecords.hospital.dto.HospitalInfoDto;
import com.example.hospitalrecords.hospital.model.HospitalInfo;
import com.example.hospitalrecords.hospital.service.HospitalService;
import com.example.hospitalrecords.department.model.Department;
import com.example.hospitalrecords.hospital.model.Hospital;
import com.example.hospitalrecords.role.model.RoleType;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/hospitals")
public class HospitalController {

    private final HospitalService hospitalService;

    @GetMapping("/description/{id}")
    public HospitalDto getHospitalDescription(@PathVariable Long id){
        return hospitalService.findById(id);
    }

    @GetMapping("/{id}")
    public HospitalDto getHospital(@PathVariable Long id){
        return hospitalService.findById(id);
    }

   @GetMapping("/{id}/hospital-info")
    public HospitalInfoDto getHospitalInfo(@PathVariable Long id){
        return hospitalService.getHospitalInfo(id);
    }

    @GetMapping("/{id}/hospital-contacts")
    public HospitalContactsDto getContacts(@PathVariable Long id){
        return hospitalService.findContactsByHospitalId(id);
    }

    @GetMapping()
    public List<HospitalDto> findAllHospitals(){
        return hospitalService.findAll();
    }
}
