package com.example.hospitalrecords.treatment.mapper;

import com.example.hospitalrecords.treatment.dto.TreatmentDto;
import com.example.hospitalrecords.treatment.model.Treatment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TreatmentMapper {

    Treatment toEntity(TreatmentDto treatmentDto);

    TreatmentDto toTreatmentDto(Treatment treatment);
}
