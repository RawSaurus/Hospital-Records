package com.example.hospitalrecords.test.model;

import com.example.hospitalrecords.doctor.model.Doctor;
import com.example.hospitalrecords.patient.model.Patient;
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
    private TestType testType;
    private double price;
    private int durationDays;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "patientId")
    private Patient patient;

    /**TODO
     *  connect with diagnosis, patient
     */


}
