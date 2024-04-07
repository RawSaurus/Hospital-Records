package com.example.hospitalrecords.treatment.model;

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
public class Treatment {

    @Id
    @GeneratedValue
    private Long treatmentId;
    private TreatmentType treatmentType;
    private double price;
    private int durationDays;
}
