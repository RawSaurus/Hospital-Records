package com.example.hospitalrecords.department.controller;

import com.example.hospitalrecords.department.dto.DepartmentInfoDto;
import com.example.hospitalrecords.department.model.Department;
import com.example.hospitalrecords.department.model.DepartmentGroup;
import com.example.hospitalrecords.department.repository.DepartmentRepository;
import com.example.hospitalrecords.department.service.DepartmentService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
       this.departmentService = departmentService;
    }

    @GetMapping
    public String welcome(){
        return "Welcome to departments";
    }
    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable Long id){
        return departmentService.findById(id);
    }

    @GetMapping("/department-info/{id}")
    public DepartmentInfoDto getDepartmentInfo(@PathVariable Long id){
        return departmentService.getDepartmentInfo(id);
    }

    @GetMapping("/department-groups")
    public List<DepartmentGroup> getAllDepartmentGroups(){
        return departmentService.getAllDepartmentGroups();
    }

    @GetMapping("/{group-id}/departments")
    public List<Department> getAllDepartmentsFromGroup(@PathVariable(name = "group-id") Long id){

        return departmentService.getAllDepartmentsFromGroup(id);
    }
    @PostMapping
    public Department postDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @PostMapping("/post-department-group")
    public DepartmentGroup postDepartmentGroup(@RequestBody DepartmentGroup departmentGroup){
        return departmentService.createDepartmentGroup(departmentGroup);
    }

    @PutMapping("/{id}")
    public Department updateDepartmentById(@PathVariable Long id, Department department){
        return departmentService.updateDepartmentById(id, department);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartmentById(@PathVariable Long id){
        return departmentService.deleteDepartmentById(id);
    }

}
