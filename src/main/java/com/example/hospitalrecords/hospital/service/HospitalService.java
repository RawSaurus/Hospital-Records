package com.example.hospitalrecords.hospital.service;

import com.example.hospitalrecords.hospital.dto.HospitalContactsDto;
import com.example.hospitalrecords.hospital.mapper.HospitalMapper;
import com.example.hospitalrecords.hospital.model.Hospital;
import com.example.hospitalrecords.hospital.model.HospitalInfo;
import com.example.hospitalrecords.hospital.repository.HospitalInfoRepository;
import com.example.hospitalrecords.hospital.repository.HospitalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
               .orElseThrow(()-> new EntityNotFoundException("Hospital Not Found"));
    }

    public Hospital saveHospital(Hospital hospital){
        return hospitalRepository.save(hospital);
    }

    public HospitalInfo postHospitalInfo(String name, HospitalInfo hospitalInfo) {
        Hospital hospital = hospitalRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Hospital not found"));
        hospitalInfo.setHospital(hospital);
        hospitalInfoRepository.save(hospitalInfo);
        hospital.setHospitalInfo(hospitalInfo);
        hospitalRepository.save(hospital);
        return hospitalInfo;
    }

    public List<Hospital> findAll(){
        return hospitalRepository.findAll();
    }

    public HospitalContactsDto findContactsByHospitalId(Long id){
        Hospital hospital = hospitalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hospital Not Found"));
        return hospitalMapper.toHospitalContactsDto(hospital.getHospitalInfo());
    }

    public Hospital updateHospital(Long id, Hospital hospital){

        Hospital updatedHospital = hospitalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hospital Not Found"));

        updatedHospital.setName(hospital.getName());

        return hospitalRepository.save(updatedHospital);
    }

    public String deleteHospital(Long id){

        Hospital deleteHospital = hospitalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hospital Not Found"));

        hospitalRepository.delete(deleteHospital);

        return "Hospital deleted successfully";
    }

    public String deleteHospitalByName(String name){

        Hospital deleteHospital = hospitalRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Hospital Not Found"));

        hospitalRepository.delete(deleteHospital);

        return "Hospital deleted successfully";
    }

    public String deleteHospitalInfo(String name){
        Hospital hospital = hospitalRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Hospital not found"));
        hospitalInfoRepository.delete(hospital.getHospitalInfo());
        return "Info deleted successfully";
    }
}
