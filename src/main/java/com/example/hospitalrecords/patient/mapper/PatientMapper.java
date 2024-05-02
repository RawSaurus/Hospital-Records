package com.example.hospitalrecords.patient.mapper;

import com.example.hospitalrecords.patient.dto.PatientRequestDto;
import com.example.hospitalrecords.patient.dto.PatientResponseDto;
import com.example.hospitalrecords.patient.model.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    PatientRequestDto toRequestDto(Patient patient);

    Patient toEntityFromRequest(PatientRequestDto patientRequestDto);

    PatientResponseDto toResponseDto(Patient patient);

    Patient toEntityFromResponse(PatientResponseDto patientResponseDto);
}
