package com.example.hospitalrecords.doctor.repository;

import com.example.hospitalrecords.doctor.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

/**Repository is connected via JpaRepository interfaces to persisting data into DB
 * No need to declare @Repository as Spring recognizes it automatically by extending JPA repositories
 * */
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
