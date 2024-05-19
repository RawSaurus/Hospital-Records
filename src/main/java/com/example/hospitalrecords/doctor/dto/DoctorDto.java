package com.example.hospitalrecords.doctor.dto;

import com.example.hospitalrecords.patient.model.Sex;

public record DoctorDto(
        String firstname,
        String lastname,
        String title,
        String email,
        String contact) {
}
