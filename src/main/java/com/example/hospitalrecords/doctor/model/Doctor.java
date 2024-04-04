package com.example.hospitalrecords.doctor.model;

import com.example.hospitalrecords.department.model.Department;
import com.example.hospitalrecords.patient.model.Patient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
* Lombok annotations
* Creating Getters, Setters, Required/All/No args constructor, toString and hashcode */
@Data
@AllArgsConstructor
@NoArgsConstructor
/**Jpa annotation, recognizes entity, creates table in SQL*/
@Entity
public class Doctor {

    /**Needed in Entity class, identifies field as Primary Key*/
    @Id
    /**Used with primary key to auto-generate values, generation type can be specified, PK ought to be non-primitive type*/
    @GeneratedValue
    private Long doctorId;
    /**Create fields, which JPA will transfer as columns into table, can add @Column to add specs as 'name', 'unique', 'nonnull', etc*/
    private String name;
    private String surname;
    private String title;
    /**Relation in jpa, if you have @ManyToMany or @OneToMany than field should be of type Set<'Entity'> or List<'Entity'>
     * Owner class is declared by 'mappedBy' value
     * For connecting entities in @ManyToMany relation se @JoinTable below
     * Value 'cascade' defines what happens with associated targets
     * */
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
