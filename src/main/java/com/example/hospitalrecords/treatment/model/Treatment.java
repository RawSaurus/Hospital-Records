package com.example.hospitalrecords.treatment.model;

import com.example.hospitalrecords.patient.model.Patient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Treatment {

    @Id
    @GeneratedValue
    private Long treatmentId;
    private String treatmentType;
    private String dosage;
    private double price;
    private int durationDays;
    @CreationTimestamp
    @Column(updatable = false, name = "started_at")
    private Date startedAt;
    @ManyToOne
    @JoinColumn(name = "patientId")
    private Patient patient;
}
