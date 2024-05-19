package com.example.hospitalrecords.department.controller;

import com.example.hospitalrecords.department.dto.DepartmentInfoDto;
import com.example.hospitalrecords.department.model.Department;
import com.example.hospitalrecords.department.model.DepartmentGroup;
import com.example.hospitalrecords.department.repository.DepartmentRepository;
import com.example.hospitalrecords.department.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.Phaser;

@RequiredArgsConstructor
@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;


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
    @PreAuthorize("hasAuthority('admin:create')")
    public String postDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @PostMapping("/post-department-group")
    @PreAuthorize("hasAuthority('admin:create')")
    public DepartmentGroup postDepartmentGroup(@RequestBody DepartmentGroup departmentGroup){
        return departmentService.createDepartmentGroup(departmentGroup);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:update')")
    public Department updateDepartmentById(@PathVariable Long id,@RequestBody Department department){
        return departmentService.updateDepartmentById(id, department);
    }

    @PutMapping("add-department-to-group/{id}")//TODO working only for dpt group
    @PreAuthorize("hasAuthority('admin:update')")
    public DepartmentGroup addDepartmentToGroup(@PathVariable Long id, @RequestBody Department department){
        return departmentService.addDepartmentToGroup(id, department);
    }

    @PutMapping("remove-department-to-group")
    @PreAuthorize("hasAuthority('admin:update')")
    public void removeDepartmentFromGroup(@RequestBody Department department, @RequestBody DepartmentGroup departmentGroup){
        departmentService.removeDepartmentFromGroup(department, departmentGroup);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public String deleteDepartmentById(@PathVariable Long id){
        return departmentService.deleteDepartmentById(id);
    }

    @DeleteMapping("/delete-department")
    @PreAuthorize("hasAuthority('admin:delete')")
    public String deleteDepartment(@RequestBody Department department){
        return departmentService.deleteDepartment(department);
    }

    @DeleteMapping("/delete-department-group")
    @PreAuthorize("hasAuthority('admin:delete')")
    public String deleteDepartmentGroup(@RequestBody DepartmentGroup departmentGroup){
        return departmentService.deleteDepartmentGroup(departmentGroup);
    }
}
