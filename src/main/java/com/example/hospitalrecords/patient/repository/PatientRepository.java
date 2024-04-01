package com.example.hospitalrecords.repository;

import com.example.hospitalrecords.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
