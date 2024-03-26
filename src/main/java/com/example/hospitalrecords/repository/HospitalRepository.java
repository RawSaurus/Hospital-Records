package com.example.hospitalrecords.repository;

import com.example.hospitalrecords.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
