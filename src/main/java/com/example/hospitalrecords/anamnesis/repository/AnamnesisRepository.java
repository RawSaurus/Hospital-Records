package com.example.hospitalrecords.anamnesis.repository;

import com.example.hospitalrecords.anamnesis.model.Anamnesis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnamnesisRepository extends JpaRepository<Anamnesis, Long> {
}
