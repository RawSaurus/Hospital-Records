package com.example.hospitalrecords.test.repository;

import com.example.hospitalrecords.test.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TestRepository extends JpaRepository<Test, Long> {

    Optional<Test> findByName(String name);
}
