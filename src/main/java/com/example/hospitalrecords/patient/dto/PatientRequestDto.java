package com.example.hospitalrecords.patient.dto;

public record PatientRequestDto(String firstName,
                                String lastName,
                                int age,
                                String email) {
}
