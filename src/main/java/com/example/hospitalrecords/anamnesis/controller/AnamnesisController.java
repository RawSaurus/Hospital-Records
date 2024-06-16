package com.example.hospitalrecords.anamnesis.controller;

import com.example.hospitalrecords.anamnesis.dto.AnamnesisRequestDto;
import com.example.hospitalrecords.anamnesis.model.Anamnesis;
import com.example.hospitalrecords.anamnesis.service.AnamnesisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/anamnesis")
public class AnamnesisController {


    private final AnamnesisService anamnesisService;

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('patient:read')")
    public AnamnesisRequestDto getAnamnesis(@PathVariable Long id){
        return anamnesisService.getAnamnesis(id);
    }

    @PostMapping("/{id}")
    @PreAuthorize("hasAuthority('doctor:create')")
    public ResponseEntity postAnamnesis(@PathVariable Long id, @RequestBody AnamnesisRequestDto anamnesis){
        return anamnesisService.postAnamnesis(id, anamnesis);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('doctor:update')")
    public ResponseEntity updateAnamnesis(@PathVariable Long id, @RequestBody AnamnesisRequestDto dto){
        return anamnesisService.updateAnamnesis(id, dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public ResponseEntity deleteAnamnesis(@PathVariable Long id){
        return anamnesisService.deleteAnamnesis(id);
    }
}
