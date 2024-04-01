package com.example.hospitalrecords.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hospital {

    @Id
    @GeneratedValue
    private Long hospitalId;
    private String name;
    @OneToMany(mappedBy = "hospital")
    private Set<Department> departments;

    @Override
    public String toString(){
        return "This is hospital: " + getName();
    }

    public void addDepartment(Department department){
        departments.add(department);
    }
}
