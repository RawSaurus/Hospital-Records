package com.example.hospitalrecords.patient.model;

import com.example.hospitalrecords.anamnesis.model.Anamnesis;
import com.example.hospitalrecords.doctor.model.Doctor;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    private String firstName;
    private String lastName;
    private int age;
    private Sex sex;
    @Column(unique=true)
    private String email;
    private double height;
    private double weight;
    private double BMI;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Diagnosis",
            joinColumns = {@JoinColumn(name = "patientId")},
            inverseJoinColumns = {@JoinColumn(name = "doctorId")}
    )
    private Set<Doctor> doctors = new HashSet<>();
    @OneToOne
    @JoinColumn(name = "anamnesisId")
    private Anamnesis anamnesis;

}
