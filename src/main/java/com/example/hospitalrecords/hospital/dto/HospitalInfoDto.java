package com.example.hospitalrecords.hospital.dto;

import com.example.hospitalrecords.resource.model.ImageData;

public record HospitalInfoDto(
            String description,
            String motto,
            String address,
            String phone,
            String hotline,
            String fax,
            String email,
            String instagram,
            String facebook,
            ImageData imageData
) {
}
