package com.example.hospitalrecords.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private Sex sex;
    @Column(unique=true)
    private String email;
    private double height;
    private double weight;
    @ManyToMany(mappedBy = "patients")//TODO JOIN TABLE
    private Set<Doctor> doctors = new HashSet<>();

}
