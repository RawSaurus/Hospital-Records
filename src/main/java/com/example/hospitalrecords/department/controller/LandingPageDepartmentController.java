package com.example.hospitalrecords.department.controller;

import com.example.hospitalrecords.department.dto.DepartmentDto;
import com.example.hospitalrecords.department.dto.DepartmentGroupDto;
import com.example.hospitalrecords.department.dto.DepartmentInfoDto;
import com.example.hospitalrecords.department.model.Department;
import com.example.hospitalrecords.department.model.DepartmentGroup;
import com.example.hospitalrecords.department.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/view-departments")
public class LandingPageDepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/{id}")
    public DepartmentDto getDepartment(@PathVariable Long id){
        return departmentService.getDepartment(id);
    }

    @GetMapping("/department-info/{id}")
    public DepartmentInfoDto getDepartmentInfo(@PathVariable Long id){
        return departmentService.getDepartmentInfo(id);
    }

    @GetMapping("/department-groups")
    public List<DepartmentGroupDto> getAllDepartmentGroups(){
        return departmentService.getAllDepartmentGroups();
    }

    @GetMapping("/{group-id}/departments")
    public List<DepartmentInfoDto> getAllDepartmentsFromGroup(@PathVariable(name = "group-id") Long id){

        return departmentService.getAllDepartmentsFromGroup(id);
    }
}
