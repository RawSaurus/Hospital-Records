package com.example.hospitalrecords.hospital.mapper;

import com.example.hospitalrecords.hospital.dto.HospitalContactsDto;
import com.example.hospitalrecords.hospital.dto.HospitalDto;
import com.example.hospitalrecords.hospital.dto.HospitalInfoDto;
import com.example.hospitalrecords.hospital.model.Hospital;
import com.example.hospitalrecords.hospital.model.HospitalInfo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface HospitalMapper {

    HospitalInfo toEntity(HospitalContactsDto hospitalContactsDto);
    Hospital toEntity(HospitalDto hospitalDto);
    HospitalInfo toEntity(HospitalInfoDto hospitalInfoDto);
    HospitalContactsDto toHospitalContactsDto(HospitalInfo hospitalInfo);
    HospitalDto toHospitalDto(Hospital hospital);
    HospitalInfoDto toHospitalInfoDto (HospitalInfo hospitalInfo);

    void updateToEntity(HospitalInfoDto dto, @MappingTarget HospitalInfo hospitalInfo);
    void updateToEntity(HospitalDto dto, @MappingTarget Hospital hospital);
}
