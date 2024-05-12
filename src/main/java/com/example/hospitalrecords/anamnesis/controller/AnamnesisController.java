package com.example.hospitalrecords.anamnesis.controller;

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
    public Anamnesis getAnamnesis(@PathVariable Long id){
        return anamnesisService.getAnamnesis(id);
    }

    @PostMapping("/{id}")
    @PreAuthorize("hasAuthority('doctor:create')")
    public Anamnesis postAnamnesis(@PathVariable Long id, @RequestBody Anamnesis anamnesis){
        return anamnesisService.postAnamnesis(id, anamnesis);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('doctor:update')")
    public Anamnesis updateAnamnesis(@PathVariable Long id, @RequestBody Anamnesis anamnesis){
        return anamnesisService.updateAnamnesis(id, anamnesis);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public ResponseEntity deleteAnamnesis(@PathVariable Long id){
        return anamnesisService.deleteAnamnesis(id);
    }
}
