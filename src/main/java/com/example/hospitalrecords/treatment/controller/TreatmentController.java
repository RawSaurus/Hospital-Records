package com.example.hospitalrecords.treatment.controller;

import com.example.hospitalrecords.treatment.dto.TreatmentDto;
import com.example.hospitalrecords.treatment.service.TreatmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/treatments")
public class TreatmentController {

    private final TreatmentService treatmentService;

    @GetMapping("/{id}/{treatmentId}")
    @PreAuthorize("hasAuthority('patient:read')")
    public TreatmentDto getTreatment(@PathVariable Long id,@PathVariable  Long treatmentId){
        return treatmentService.getTreatment(id, treatmentId);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('patient:read')")
    public List<TreatmentDto> getAllTreatments(@PathVariable Long id){
        return treatmentService.getAllTreatments(id);
    }

    @PostMapping("/{id}")
    @PreAuthorize("hasAuthority('doctor:create')")
    public ResponseEntity postTreatment(@PathVariable Long id, @RequestBody TreatmentDto treatmentDto){
       return treatmentService.postTreatment(id, treatmentDto);
    }

    @PutMapping("/{id}/{treatmentId}")
    @PreAuthorize("hasAuthority('admin:update')")
    public ResponseEntity updateTreatment(@PathVariable Long id, @PathVariable Long treatmentId, @RequestBody TreatmentDto treatmentDto){
       return treatmentService.updateTreatment(id, treatmentId, treatmentDto);
    }

    @DeleteMapping("/{id}/{treatmentId}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public ResponseEntity deleteTreatment(@PathVariable Long id, @PathVariable Long treatmentId){
        return treatmentService.deleteTreatment(id, treatmentId);
    }

}
