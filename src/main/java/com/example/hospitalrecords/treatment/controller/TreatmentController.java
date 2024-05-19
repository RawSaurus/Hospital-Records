package com.example.hospitalrecords.treatment.controller;

import com.example.hospitalrecords.treatment.dto.TreatmentDto;
import com.example.hospitalrecords.treatment.service.TreatmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/treatments")
public class TreatmentController {

    private final TreatmentService treatmentService;

    @GetMapping("/{id}/{treatmentType}")
    @PreAuthorize("hasAuthority('patient:read')")
    public TreatmentDto getTreatment(@PathVariable Long id,@PathVariable  String treatmentType){
        return treatmentService.getTreatment(id, treatmentType);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('patient:read')")
    public List<TreatmentDto> getAllTreatments(@PathVariable Long id){
        return treatmentService.getAllTreatments(id);
    }

    @PostMapping("/{id}")
    @PreAuthorize("hasAuthority('doctor:create')")
    public void postTreatment(@PathVariable Long id, @RequestBody TreatmentDto treatmentDto){
       treatmentService.postTreatment(id, treatmentDto);
    }

    @PutMapping("/{id}/{treatmentType}")
    @PreAuthorize("hasAuthority('admin:update')")
    public void updateTreatment(@PathVariable Long id, @PathVariable String treatmentType, @RequestBody TreatmentDto treatmentDto){
       treatmentService.updateTreatment(id, treatmentType, treatmentDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public void deleteTreatment(@PathVariable Long id){
        treatmentService.deleteTreatment(id);
    }

}
