package com.example.hospitalrecords.treatment.dto;

public record TreatmentDto(
        String treatmentType,
        String dosage,
        double price,
        int durationDays
) {
}
