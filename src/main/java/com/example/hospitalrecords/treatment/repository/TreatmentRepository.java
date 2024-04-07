package com.example.hospitalrecords.treatment.repository;

import com.example.hospitalrecords.treatment.model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
}
