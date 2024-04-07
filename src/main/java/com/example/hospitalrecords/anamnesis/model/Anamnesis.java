package com.example.hospitalrecords.anamnesis.model;

import com.example.hospitalrecords.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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
    private String description;
    @OneToOne
    @JoinColumn(name = "userId")
    private User user;
}
