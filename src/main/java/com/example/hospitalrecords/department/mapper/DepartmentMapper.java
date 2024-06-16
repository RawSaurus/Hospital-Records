package com.example.hospitalrecords.department.mapper;

import com.example.hospitalrecords.department.dto.DepartmentDto;
import com.example.hospitalrecords.department.dto.DepartmentGroupDto;
import com.example.hospitalrecords.department.dto.DepartmentInfoDto;
import com.example.hospitalrecords.department.model.Department;
import com.example.hospitalrecords.department.model.DepartmentGroup;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    DepartmentInfoDto toDeptInfoDto(Department department);

    DepartmentDto toDepartmentDto(Department department);

    DepartmentGroupDto toDepartmentGroupDto(DepartmentGroup departmentgroup);

    Department toEntity(DepartmentInfoDto deptInfoDto);
    Department toEntity(DepartmentDto deptDto);
    DepartmentGroup toEntity(DepartmentGroupDto deptGroupDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateToEntity(DepartmentDto dto, @MappingTarget Department Department);
}
