package com.example.hospitalrecords.role.repository;

import com.example.hospitalrecords.role.model.Role;
import com.example.hospitalrecords.role.model.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleType name);
}
