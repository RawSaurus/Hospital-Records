package com.example.hospitalrecords.department.dto;

import com.example.hospitalrecords.doctor.model.Doctor;
import com.example.hospitalrecords.resource.model.ImageData;

import java.util.List;

public record DepartmentDto(
        String name,
        String description,
        List<ImageData> images,
        List<Doctor> doctors
) {
}
