package com.example.hospitalrecords.anamnesis.model;

import com.example.hospitalrecords.patient.model.Patient;
import com.example.hospitalrecords.treatment.model.Treatment;
import com.example.hospitalrecords.user.model.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.ArrayList;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Anamnesis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long anamnesisId;
    private String title;
    @Lob
    private String history;
    private ArrayList<String> hospitalizations;
    private ArrayList<String> treatments;
    private ArrayList<String> diagnosis;
    @OneToOne
    @JoinColumn(name = "patientId")
    @JsonManagedReference
    @Cascade(value = CascadeType.DELETE_ORPHAN)
    private Patient patient;

}
