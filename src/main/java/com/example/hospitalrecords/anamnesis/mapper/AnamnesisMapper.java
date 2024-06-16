package com.example.hospitalrecords.anamnesis.mapper;

import com.example.hospitalrecords.anamnesis.dto.AnamnesisRequestDto;
import com.example.hospitalrecords.anamnesis.model.Anamnesis;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface AnamnesisMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateToEntity(AnamnesisRequestDto dto, @MappingTarget  Anamnesis anamnesis);

    Anamnesis toEntity(AnamnesisRequestDto dto);

    AnamnesisRequestDto toRequestDto(Anamnesis anamnesis);
}

