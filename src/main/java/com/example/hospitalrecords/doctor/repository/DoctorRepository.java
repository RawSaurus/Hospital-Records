package com.example.hospitalrecords.doctor.repository;

import com.example.hospitalrecords.doctor.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
