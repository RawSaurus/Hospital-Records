package com.example.hospitalrecords.hospital.model;

import com.example.hospitalrecords.department.model.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @OneToMany(mappedBy = "hospital",
    fetch = FetchType.LAZY)
    private Set<Department> departments;

    @Override
    public String toString(){
        return "This is hospital: " + getName();
    }

    public void addDepartment(Department department){
        departments.add(department);
    }
}
