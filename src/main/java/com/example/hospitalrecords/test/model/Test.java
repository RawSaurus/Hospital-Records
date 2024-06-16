package com.example.hospitalrecords.test.model;

import com.example.hospitalrecords.doctor.model.Doctor;
import com.example.hospitalrecords.patient.model.Patient;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Test {

    @Id
    @GeneratedValue
    private Long testId;
    private String name;
    @Column
    @Enumerated(EnumType.STRING)
    private TestType testType;
    private Date date;
//    @ManyToOne
//    @JoinColumn(name = "userId")
//    @JsonBackReference
//    private Patient patient;

}
