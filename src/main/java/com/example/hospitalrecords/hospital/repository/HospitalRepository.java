package com.example.hospitalrecords.hospital.repository;

import com.example.hospitalrecords.hospital.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {

}
