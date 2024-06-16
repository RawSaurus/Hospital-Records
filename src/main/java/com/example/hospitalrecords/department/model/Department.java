package com.example.hospitalrecords.department.model;

import com.example.hospitalrecords.hospital.model.Hospital;
import com.example.hospitalrecords.doctor.model.Doctor;
import com.example.hospitalrecords.patient.model.Patient;
import com.example.hospitalrecords.resource.model.ImageData;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deptId;
    @NotEmpty(message = "you should provide a name")
    private String name;
    @Lob
    private String description;
    @OneToMany
    private List<ImageData> images;
    @ManyToOne
    @JoinColumn(name = "hospitalId")
    private Hospital hospital;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Department_Doctor",
            joinColumns = {@JoinColumn(name = "deptId")},
            inverseJoinColumns = {@JoinColumn(name = "doctorId")}
    )
    private List<Doctor> doctors;
    @ManyToOne
    @JsonBackReference
    private DepartmentGroup departmentGroup;
    @OneToMany
    private List<Patient> patients;


}
