package com.example.hospitalrecords.hospital.dto;

import com.example.hospitalrecords.department.dto.DepartmentInfoDto;
import com.example.hospitalrecords.department.model.Department;

import java.util.List;

public record HospitalDto(
        String name,
        List<DepartmentInfoDto> departments
) {
}
