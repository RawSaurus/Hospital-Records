package com.example.hospitalrecords.hospital.model;

import com.example.hospitalrecords.resource.model.ImageData;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hospital_info")
public class HospitalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hospitalInfoId;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String description;
    private String motto;
    private String address;
    private String phone;
    private String hotline;
    private String fax;
    private String email;
    private String instagram;
    private String facebook;
    @OneToOne
    @JoinColumn(name = "hospitalId")
    @JsonBackReference
    private Hospital hospital;
    @OneToOne
    @JoinColumn(name = "imageDataId")
    private ImageData ImageData;//logo
}
