package com.example.hospitalrecords.anamnesis.dto;

import org.mapstruct.BeanMapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

public record AnamnesisRequestDto(
        String title,
        String history,
        List<String> hospitalizations,
        List<String> treatments,
        List<String> diagnosis
) {
}
