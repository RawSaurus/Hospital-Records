package com.example.hospitalrecords.department.dto;

import com.example.hospitalrecords.resource.model.ImageData;
import lombok.Data;

import java.util.List;

@Data
public class DepartmentInfoDto {

    private String name;
    private String description;
    private List<ImageData> images;
}
