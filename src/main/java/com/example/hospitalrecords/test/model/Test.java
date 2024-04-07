package com.example.hospitalrecords.test.model;

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
public class Test {

    @Id
    @GeneratedValue
    private Long testId;
    private String name;
    private TestType testType;
    private double price;
    private int durationDays;


}
