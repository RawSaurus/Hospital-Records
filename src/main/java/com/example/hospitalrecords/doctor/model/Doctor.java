package com.example.hospitalrecords.doctor.model;

import com.example.hospitalrecords.department.model.Department;
import com.example.hospitalrecords.patient.model.Patient;
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
public class Doctor {

    @Id
    @GeneratedValue
    private Long doctorId;
    private String name;
    private String surname;
    private String title;
    @ManyToMany(mappedBy = "doctors")
    private Set<Department> departments = new HashSet<>();
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Diagnosis",
            joinColumns = {@JoinColumn(name = "doctorId")},
            inverseJoinColumns = {@JoinColumn(name = "id")}
    )
    private Set<Patient> patients = new HashSet<>();
}
