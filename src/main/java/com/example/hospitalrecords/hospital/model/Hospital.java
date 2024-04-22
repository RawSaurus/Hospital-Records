package com.example.hospitalrecords.hospital.model;

import com.example.hospitalrecords.department.model.Department;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Hospital {

    @Id
    @GeneratedValue
    private Long hospitalId;
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "hospital")
    private List<Department> departments;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hospitalInfoId")
    @JsonManagedReference
    private HospitalInfo hospitalInfo;



    /**\/hospital
     * Logo, motto, name, address, contact(phone, fax, email, socials)
     * pictures(more details url)
     * List<Services>
     * News, List of last ten announcements
     * Google map API
     *
     * /hospital/history
     * name, text, pictures, source*/

}
