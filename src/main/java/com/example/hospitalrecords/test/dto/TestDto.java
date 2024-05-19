package com.example.hospitalrecords.test.dto;

import com.example.hospitalrecords.test.model.TestType;

import java.util.Date;

public record TestDto(
        String name,
        TestType testType,
        Date date
) {
}
