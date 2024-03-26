package com.example.hospitalrecords.repository;

import com.example.hospitalrecords.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
