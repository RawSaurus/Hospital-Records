package com.example.hospitalrecords.hospital.controller;

import com.example.hospitalrecords.hospital.model.Hospital;
import com.example.hospitalrecords.hospital.model.HospitalInfo;
import com.example.hospitalrecords.hospital.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receptionist/hospitals")
@PreAuthorize("hasRole('RECEPTIONIST')")
@RequiredArgsConstructor
public class ReceptionistHospitalController {

   private final HospitalService hospitalService;

   @PostMapping("/{name}")
   @PreAuthorize("hasAuthority('receptionist:create')")
   public HospitalInfo postHospitalInfo(@PathVariable String name, @RequestBody HospitalInfo hospitalInfo){
      return hospitalService.postHospitalInfo(name, hospitalInfo);
   }
   @PutMapping("/{name}")
   @PreAuthorize("hasAuthority('receptionist:update')")
   public HospitalInfo updateHospitalInfo(@PathVariable String name, @RequestBody HospitalInfo hospitalInfo) {
      return hospitalService.postHospitalInfo(name, hospitalInfo);
   }
   @DeleteMapping("/{name}")
   @PreAuthorize("hasAuthority('receptionist:delete')")
   public String deleteHospitalInfo(@PathVariable String name){
      return hospitalService.deleteHospitalInfo(name);
   }
}
