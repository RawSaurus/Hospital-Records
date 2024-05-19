package com.example.hospitalrecords.department.controller;

import com.example.hospitalrecords.department.dto.DepartmentInfoDto;
import com.example.hospitalrecords.department.model.Department;
import com.example.hospitalrecords.department.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/view-departments")
public class LandingPageDepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/{id}")
    public DepartmentInfoDto getDepartment(@PathVariable Long id){
        return departmentService.findById(id);
    }
}
