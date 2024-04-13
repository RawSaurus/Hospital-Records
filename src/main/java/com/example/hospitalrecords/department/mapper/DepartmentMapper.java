package com.example.hospitalrecords.department.mapper;

import com.example.hospitalrecords.department.dto.DepartmentInfoDto;
import com.example.hospitalrecords.department.model.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    DepartmentInfoDto toDeptInfoDto(Department department);

    Department toEntity(DepartmentInfoDto deptInfoDto);
}
