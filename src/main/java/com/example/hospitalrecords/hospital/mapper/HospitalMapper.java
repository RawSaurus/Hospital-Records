package com.example.hospitalrecords.hospital.mapper;

import com.example.hospitalrecords.hospital.dto.HospitalContactsDto;
import com.example.hospitalrecords.hospital.model.HospitalInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HospitalMapper {

    HospitalInfo toEntity(HospitalContactsDto hospitalContactsDto);
    HospitalContactsDto toHospitalContactsDto(HospitalInfo hospitalInfo);
}
