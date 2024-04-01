package com.example.hospitalrecords.department.repository;

import com.example.hospitalrecords.department.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
