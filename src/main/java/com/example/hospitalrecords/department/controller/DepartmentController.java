package com.example.hospitalrecords.department.controller;

import com.example.hospitalrecords.department.dto.DepartmentDto;
import com.example.hospitalrecords.department.dto.DepartmentGroupDto;
import com.example.hospitalrecords.department.dto.DepartmentInfoDto;
import com.example.hospitalrecords.department.model.Department;
import com.example.hospitalrecords.department.model.DepartmentGroup;
import com.example.hospitalrecords.department.repository.DepartmentRepository;
import com.example.hospitalrecords.department.service.DepartmentService;
import jakarta.validation.Valid;
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


    @PostMapping("/{departmentGroupId}")
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity postDepartment(@PathVariable Long departmentGroupId, @RequestBody @Valid DepartmentInfoDto department){ //TODO validate on controller level
        return departmentService.saveDepartment(departmentGroupId, department);
    }

    @PostMapping("/post-department-group")
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity postDepartmentGroup(@RequestBody DepartmentGroupDto departmentGroup){
        return departmentService.createDepartmentGroup(departmentGroup);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:update')")
    public ResponseEntity updateDepartmentById(@PathVariable Long id,@RequestBody DepartmentDto department){
        return departmentService.updateDepartmentById(id, department);
    }

    @DeleteMapping("/{id}/{departmentId}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public ResponseEntity deleteDepartmentById(@PathVariable Long id, @PathVariable Long departmentId){
        return departmentService.deleteDepartmentById(id,departmentId);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public ResponseEntity deleteDepartmentGroup(@PathVariable Long id){
        return departmentService.deleteDepartmentGroup(id);
    }
}
