package com.example.hospitalrecords.department.service;

import com.example.hospitalrecords.department.dto.DepartmentInfoDto;
import com.example.hospitalrecords.department.mapper.DepartmentMapper;
import com.example.hospitalrecords.department.model.Department;
import com.example.hospitalrecords.department.model.DepartmentGroup;
import com.example.hospitalrecords.department.repository.DepartmentGroupRepository;
import com.example.hospitalrecords.department.repository.DepartmentRepository;
import com.example.hospitalrecords.hospital.model.Hospital;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@AllArgsConstructor
@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentGroupRepository departmentGroupRepository;
    private final DepartmentMapper departmentMapper;

    public Department saveDepartment(Department department){
        return departmentRepository.save(department);
    }

    public List<DepartmentGroup> getAllDepartmentGroups(){
        return departmentGroupRepository.findAll();
    }

    public DepartmentInfoDto getDepartmentInfo(Long id){
        return departmentRepository.findById(id)
                .map(departmentMapper::toDeptInfoDto)
                .orElseThrow(()-> new RuntimeException("Departmetn Not Found"));
    }

    public DepartmentGroup createDepartmentGroup(DepartmentGroup departmentGroup){
        return departmentGroupRepository.save(departmentGroup);
    }

    public Department findById(Long id){
        return departmentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Hospital Not Found"));
    }


    public List<Department> getAllDepartmentsFromGroup(Long id){

        return departmentGroupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Group Not Found"))
                .getDepartments();
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
