package com.example.hospitalrecords.department.repository;

import com.example.hospitalrecords.department.model.DepartmentGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentGroupRepository extends JpaRepository<DepartmentGroup, Long> {
}
