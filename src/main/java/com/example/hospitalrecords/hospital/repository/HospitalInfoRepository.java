package com.example.hospitalrecords.hospital.repository;

import com.example.hospitalrecords.hospital.model.HospitalInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalInfoRepository extends JpaRepository<HospitalInfo, Long>{
}
