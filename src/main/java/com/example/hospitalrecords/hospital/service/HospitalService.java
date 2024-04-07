package com.example.hospitalrecords.hospital.service;

import com.example.hospitalrecords.hospital.model.Hospital;
import com.example.hospitalrecords.hospital.repository.HospitalRepository;
import com.example.hospitalrecords.department.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository){
        this.hospitalRepository = hospitalRepository;
    }

    public Hospital findById(Long id){
       return hospitalRepository.findById(id)
               .orElseThrow(()-> new RuntimeException("Hospital Not Found"));
    }

    public Hospital saveHospital(Hospital hospital){
        return hospitalRepository.save(hospital);
    }

    public List<Hospital> findAll(){
        return hospitalRepository.findAll();
    }

    public Hospital updateHospital(Long id, Hospital hospital){

        Hospital updatedHospital = hospitalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hospital Not Found"));

        updatedHospital.setName(hospital.getName());

        return hospitalRepository.save(updatedHospital);
    }

    public String deleteHospital(Long id){

        Hospital deleteHospital = hospitalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hospital Not Found"));

        hospitalRepository.delete(deleteHospital);

        return "Hospital deleted successfully";
    }
}
