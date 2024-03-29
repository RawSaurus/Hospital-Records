package com.example.hospitalrecords.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String sex;
    @Column(unique=true)
    private String email;
    private double height;
    private double weight;

}
