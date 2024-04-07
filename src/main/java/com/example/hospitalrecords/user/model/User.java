package com.example.hospitalrecords.user.model;

import com.example.hospitalrecords.anamnesis.model.Anamnesis;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_tbl")
public class User {

    @Id
    @GeneratedValue
    private Long userId;
    private String name;
    @Column(unique = true)
    private String email;
    private String userName;
    private String contact;
    @OneToOne
    @JoinColumn(name = "anamnesisId")
    private Anamnesis anamnesis;
}
