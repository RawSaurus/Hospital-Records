package com.example.hospitalrecords.controller;

import com.example.hospitalrecords.model.Department;
import com.example.hospitalrecords.repository.DepartmentRepository;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository){
       this.departmentRepository = departmentRepository;
    }

    @GetMapping
    public String welcome(){
        return "Welcome to departments";
    }

    @PostMapping
    public Department postDepartment(@RequestBody Department department){
        return departmentRepository.save(department);
    }

    @PutMapping("/{id}")
    public Department updateDepartmentById(@PathVariable Long id, Department department){
        Department updatedDepartment = departmentRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Department Not Found"));

        updatedDepartment.setName(department.getName());
        return departmentRepository.save(updatedDepartment);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartmentById(@PathVariable Long id){
        if(departmentRepository.existsById(id)){
            departmentRepository.deleteById(id);
            return "Department deleted successfully";
        }
        else
            throw new RuntimeException("Department Not Found");
    }

}
