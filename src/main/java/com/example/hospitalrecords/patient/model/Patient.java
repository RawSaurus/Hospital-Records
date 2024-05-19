package com.example.hospitalrecords.patient.model;

import com.example.hospitalrecords.anamnesis.model.Anamnesis;
import com.example.hospitalrecords.doctor.model.Doctor;
import com.example.hospitalrecords.test.model.Test;
import com.example.hospitalrecords.treatment.model.Treatment;
import com.example.hospitalrecords.user.model.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient extends User {

    private int age;
    private Sex sex;
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
    @JsonBackReference
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private Anamnesis anamnesis;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private List<Test> tests;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private List<Treatment> treatments;

}
