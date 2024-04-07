package com.example.hospitalrecords.department.service;

import com.example.hospitalrecords.department.model.Department;
import com.example.hospitalrecords.department.repository.DepartmentRepository;
import com.example.hospitalrecords.hospital.model.Hospital;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    public Department saveDepartment(Department department){
        return departmentRepository.save(department);
    }

    public Department findById(Long id){
        return departmentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Hospital Not Found"));
    }

    public Department updateDepartmentById(Long id, Department department){

        Department updatedDepartment = departmentRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Department Not Found"));

        updatedDepartment.setName(department.getName());
        return departmentRepository.save(updatedDepartment);
    }

    public String deleteDepartmentById(Long id){

        Department deletedDepartment= departmentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Department Not Found"));

        departmentRepository.delete(deletedDepartment);
        return "Department deleted successfully";
    }
}
