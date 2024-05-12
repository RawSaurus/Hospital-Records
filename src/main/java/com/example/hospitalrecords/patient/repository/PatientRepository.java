package com.example.hospitalrecords.patient.repository;

import com.example.hospitalrecords.patient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByLastnameOrFirstname(String lastname, String firstname);

}
