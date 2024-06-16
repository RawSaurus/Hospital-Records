package com.example.hospitalrecords.department.model;

import com.example.hospitalrecords.resource.model.ImageData;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DepartmentGroup {

    @Id
    @GeneratedValue
    private Long departmentGroupId;
    private String groupName;
    @OneToOne
    @JoinColumn(name = "imageDataId")
    private ImageData imageData;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private List<Department> departments;

}
