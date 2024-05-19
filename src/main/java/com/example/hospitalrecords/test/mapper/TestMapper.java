package com.example.hospitalrecords.test.mapper;

import com.example.hospitalrecords.test.dto.TestDto;
import com.example.hospitalrecords.test.model.Test;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TestMapper {

    Test toEntity(TestDto testDto);

    TestDto toTestDto(Test test);
}
