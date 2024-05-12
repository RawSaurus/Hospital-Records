package com.example.hospitalrecords.doctor.model;

import com.example.hospitalrecords.department.model.Department;
import com.example.hospitalrecords.patient.model.Patient;
import com.example.hospitalrecords.user.model.User;
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
public class Doctor extends User{

    private String title;
    @ManyToMany(mappedBy = "doctors")
    private Set<Department> departments = new HashSet<>();
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Diagnosis",
            joinColumns = {@JoinColumn(name = "doctorId")},
            inverseJoinColumns = {@JoinColumn(name = "patientId")}
    )
    private Set<Patient> patients = new HashSet<>();


}
