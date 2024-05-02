package com.example.hospitalrecords.doctor.mapper;


import com.example.hospitalrecords.doctor.dto.DoctorInfoDto;
import com.example.hospitalrecords.doctor.model.Doctor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    DoctorInfoDto toDocInfoDto(Doctor doctor);

    DoctorInfoDto toEntity(DoctorInfoDto doctorInfoDto);
}
