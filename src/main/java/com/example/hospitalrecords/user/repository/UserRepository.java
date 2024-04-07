package com.example.hospitalrecords.user.repository;

import com.example.hospitalrecords.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
