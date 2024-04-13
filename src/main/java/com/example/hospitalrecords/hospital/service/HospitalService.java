package com.example.hospitalrecords.hospital.service;

import com.example.hospitalrecords.hospital.dto.HospitalContactsDto;
import com.example.hospitalrecords.hospital.mapper.HospitalMapper;
import com.example.hospitalrecords.hospital.model.Hospital;
import com.example.hospitalrecords.hospital.repository.HospitalInfoRepository;
import com.example.hospitalrecords.hospital.repository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;
    private final HospitalInfoRepository hospitalInfoRepository;
    private final HospitalMapper hospitalMapper;

    public HospitalService(HospitalRepository hospitalRepository, HospitalInfoRepository hospitalInfoRepository, HospitalMapper hospitalMapper) {
        this.hospitalRepository = hospitalRepository;
        this.hospitalInfoRepository = hospitalInfoRepository;
        this.hospitalMapper = hospitalMapper;
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

    public HospitalContactsDto findContactsByHospitalId(Long id){
        Hospital hospital = hospitalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hospital Not Found"));
        return hospitalMapper.toHospitalContactsDto(hospital.getHospitalInfo());
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
