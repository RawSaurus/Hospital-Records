package com.example.hospitalrecords.treatment.mapper;

import com.example.hospitalrecords.treatment.dto.TreatmentDto;
import com.example.hospitalrecords.treatment.model.Treatment;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface TreatmentMapper {

    Treatment toEntity(TreatmentDto treatmentDto);

    TreatmentDto toTreatmentDto(Treatment treatment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateToEntity(TreatmentDto dto, @MappingTarget Treatment treatment);
}
