package com.example.hospitalrecords.repository;

import com.example.hospitalrecords.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {

}
