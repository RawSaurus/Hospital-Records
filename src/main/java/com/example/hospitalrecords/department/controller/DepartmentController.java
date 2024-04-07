package com.example.hospitalrecords.department.controller;

import com.example.hospitalrecords.department.model.Department;
import com.example.hospitalrecords.department.repository.DepartmentRepository;
import com.example.hospitalrecords.department.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    public Department postDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
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
