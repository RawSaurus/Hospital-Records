package com.example.hospitalrecords.department.service;

import com.example.hospitalrecords.department.dto.DepartmentInfoDto;
import com.example.hospitalrecords.department.mapper.DepartmentMapper;
import com.example.hospitalrecords.department.model.Department;
import com.example.hospitalrecords.department.model.DepartmentGroup;
import com.example.hospitalrecords.department.repository.DepartmentGroupRepository;
import com.example.hospitalrecords.department.repository.DepartmentRepository;
import com.example.hospitalrecords.hospital.model.Hospital;
import com.example.hospitalrecords.validation.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentGroupRepository departmentGroupRepository;
    private final DepartmentMapper departmentMapper;
    private final ObjectsValidator<Department> validator;

    public String saveDepartment(Department department){
        Set<String> violations = validator.validate(department);
        if(!violations.isEmpty()){
            return String.join(" | ", violations);
        }
        return departmentRepository.save(department).toString();
    }

    public List<DepartmentGroup> getAllDepartmentGroups(){
        return departmentGroupRepository.findAll();
    }

    public DepartmentInfoDto getDepartmentInfo(Long id){
        return departmentRepository.findById(id)
                .map(departmentMapper::toDeptInfoDto)
                .orElseThrow(()-> new EntityNotFoundException("Departmetn Not Found"));
    }

    public DepartmentGroup createDepartmentGroup(DepartmentGroup departmentGroup){
        return departmentGroupRepository.save(departmentGroup);
    }

    public DepartmentInfoDto findById(Long id){
        return departmentRepository.findById(id)
                .map(departmentMapper::toDeptInfoDto)
                .orElseThrow(()-> new EntityNotFoundException("Hospital Not Found"));
    }


    public List<Department> getAllDepartmentsFromGroup(Long id){//TODO DTO

        return departmentGroupRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Group Not Found"))
                .getDepartments();
    }

    public Department updateDepartmentById(Long id, Department department){

        Department updatedDepartment = departmentRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Department Not Found"));

        updatedDepartment.setName(department.getName());
        return departmentRepository.save(updatedDepartment);
    }

    public DepartmentGroup addDepartmentToGroup(Long id, Department department){//TODO not working
        DepartmentGroup updateGroup = departmentGroupRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Group not found"));

        if(!updateGroup.getDepartments().contains(department)){
            updateGroup.getDepartments().add(department);
            departmentGroupRepository.save(updateGroup);
        }else
            return null;

        return updateGroup;
    }

    public void removeDepartmentFromGroup(Department department, DepartmentGroup departmentGroup){//TODO not working
        DepartmentGroup updateGroup = departmentGroupRepository.findById(departmentGroup.getDepartmentGroupId())
                .orElseThrow(() -> new EntityNotFoundException("Group not found"));

        updateGroup.getDepartments().remove(department);
    }

    public String deleteDepartmentById(Long id){

        Department deletedDepartment= departmentRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Department Not Found"));

        departmentRepository.delete(deletedDepartment);
        return "Department deleted successfully";
    }

    public String deleteDepartment(Department department){
        departmentRepository.delete(department);
        return "Department deleted successfully";
    }

    public String deleteDepartmentGroup(DepartmentGroup departmentGroup){
        departmentGroupRepository.delete(departmentGroup);
        return "Department deleted successfully";
    }
}
