package com.example.hospitalrecords.repository;

import com.example.hospitalrecords.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
