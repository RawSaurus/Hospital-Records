package com.example.hospitalrecords.department.dto;

import com.example.hospitalrecords.department.model.Department;
import com.example.hospitalrecords.resource.model.ImageData;

import java.util.List;

public record DepartmentGroupDto(
        String groupName,
        ImageData imageData,
        List<Department> departments
) {
}
