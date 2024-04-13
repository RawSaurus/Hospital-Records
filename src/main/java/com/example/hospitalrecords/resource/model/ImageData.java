package com.example.hospitalrecords.resource.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ImageData {

    @Id
    @GeneratedValue
    private Long imageDataId;
    private String name;
    @Lob
    private byte[] imageData;
}
