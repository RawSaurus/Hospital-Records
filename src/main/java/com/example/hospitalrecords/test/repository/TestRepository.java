package com.example.hospitalrecords.test.repository;

import com.example.hospitalrecords.test.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}
