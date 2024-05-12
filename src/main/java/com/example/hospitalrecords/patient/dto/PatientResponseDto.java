package com.example.hospitalrecords.patient.dto;

import com.example.hospitalrecords.patient.model.Sex;

public record PatientResponseDto(String firstname,
                                 String lastname,
                                 int age,
                                 String email,
                                 Sex sex,
                                 double height,
                                 double weight,
                                 String contact) {
}
