package com.example.hospitalrecords.test.mapper;

import com.example.hospitalrecords.test.dto.TestDto;
import com.example.hospitalrecords.test.model.Test;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface TestMapper {

    Test toEntity(TestDto testDto);

    TestDto toTestDto(Test test);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateToEntity(TestDto testDto, @MappingTarget Test test);
}
