package com.example.hospitalrecords.department.service;

import com.example.hospitalrecords.department.dto.DepartmentDto;
import com.example.hospitalrecords.department.dto.DepartmentGroupDto;
import com.example.hospitalrecords.department.dto.DepartmentInfoDto;
import com.example.hospitalrecords.department.mapper.DepartmentMapper;
import com.example.hospitalrecords.department.model.Department;
import com.example.hospitalrecords.department.model.DepartmentGroup;
import com.example.hospitalrecords.department.repository.DepartmentGroupRepository;
import com.example.hospitalrecords.department.repository.DepartmentRepository;
import com.example.hospitalrecords.validation.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentGroupRepository departmentGroupRepository;
    private final DepartmentMapper departmentMapper;
    private final ObjectsValidator<Department> validator;


    public DepartmentDto getDepartment(Long id){
        return departmentRepository.findById(id)
                .map(departmentMapper::toDepartmentDto)
                .orElseThrow(()-> new EntityNotFoundException("Hospital Not Found"));
    }

    public List<DepartmentGroupDto> getAllDepartmentGroups(){
        return departmentGroupRepository.findAll()
                .stream()
                .map(departmentMapper::toDepartmentGroupDto)
                .collect(Collectors.toList());
    }

    public List<DepartmentInfoDto> getAllDepartmentsFromGroup(Long id){

        return departmentGroupRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Group Not Found"))
                .getDepartments()
                .stream()
                .map(departmentMapper::toDeptInfoDto)
                .collect(Collectors.toList());
    }

    public DepartmentInfoDto getDepartmentInfo(Long id){
        return departmentRepository.findById(id)
                .map(departmentMapper::toDeptInfoDto)
                .orElseThrow(()-> new EntityNotFoundException("Department Not Found"));
    }

    public ResponseEntity saveDepartment(Long departmentGroupId, DepartmentInfoDto departmentInfoDto){
        DepartmentGroup departmentGroup = departmentGroupRepository.findById(departmentGroupId)
                        .orElseThrow(() -> new EntityNotFoundException("Department Group not found"));
        Department department = departmentMapper.toEntity(departmentInfoDto);

        department.setDepartmentGroup(departmentGroup);
        departmentGroup.getDepartments().add(department);
        departmentGroupRepository.save(departmentGroup);

        return ResponseEntity.ok("Department Created");
    }

    public ResponseEntity createDepartmentGroup(DepartmentGroupDto departmentGroupDto){
        departmentGroupRepository.save(departmentMapper.toEntity(departmentGroupDto));
        return ResponseEntity.ok("Department group created");
    }

    public ResponseEntity updateDepartmentById(Long id, DepartmentDto departmentDto){

        Department updatedDepartment = departmentRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Department Not Found"));

        departmentMapper.updateToEntity(departmentDto, updatedDepartment);
        departmentRepository.save(updatedDepartment);

        return ResponseEntity.ok("Department updated");
    }

    public ResponseEntity deleteDepartmentById(Long id, Long departmentId){

        DepartmentGroup departmentGroup= departmentGroupRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Department Group Not Found"));

        for(int i = 0; i<departmentGroup.getDepartments().size(); i++){
            if(departmentGroup.getDepartments().get(i).getDeptId().equals(departmentId)){
                departmentGroup.getDepartments().remove(i);
                departmentGroupRepository.save(departmentGroup);
                departmentRepository.deleteById(departmentId);
                break;
            }
        }

        return ResponseEntity.ok("Department Deleted");
    }

    public ResponseEntity deleteDepartmentGroup(Long id){
        departmentGroupRepository.deleteById(id);
        return ResponseEntity.ok("Group deleted");
    }
}
