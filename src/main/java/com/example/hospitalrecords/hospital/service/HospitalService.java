package com.example.hospitalrecords.hospital.service;

import com.example.hospitalrecords.hospital.dto.HospitalContactsDto;
import com.example.hospitalrecords.hospital.dto.HospitalDto;
import com.example.hospitalrecords.hospital.dto.HospitalInfoDto;
import com.example.hospitalrecords.hospital.mapper.HospitalMapper;
import com.example.hospitalrecords.hospital.model.Hospital;
import com.example.hospitalrecords.hospital.model.HospitalInfo;
import com.example.hospitalrecords.hospital.repository.HospitalInfoRepository;
import com.example.hospitalrecords.hospital.repository.HospitalRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;
    private final HospitalInfoRepository hospitalInfoRepository;
    private final HospitalMapper hospitalMapper;

    public HospitalDto findById(Long id){
       return hospitalMapper.toHospitalDto(
                hospitalRepository.findById(id)
               .orElseThrow(()-> new EntityNotFoundException("Hospital Not Found")));
    }

    public List<HospitalDto> findAll(){
        return hospitalRepository.findAll()
                .stream()
                .map(hospitalMapper::toHospitalDto)
                .collect(Collectors.toList());
    }

    public HospitalInfoDto getHospitalInfo(Long id){
        return hospitalMapper.toHospitalInfoDto(hospitalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hospital not found"))
                .getHospitalInfo());
    }

    public HospitalContactsDto findContactsByHospitalId(Long id){
        Hospital hospital = hospitalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hospital Not Found"));
        return hospitalMapper.toHospitalContactsDto(hospital.getHospitalInfo());
    }

    public ResponseEntity saveHospital(HospitalDto hospitalDto){
        hospitalRepository.save(hospitalMapper.toEntity(hospitalDto));
        return ResponseEntity.ok("Hospital saved");
    }

    public ResponseEntity postHospitalInfo(String name, HospitalInfoDto hospitalInfoDto) {
        Hospital hospital = hospitalRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Hospital not found"));

        hospital.setHospitalInfo(hospitalMapper.toEntity(hospitalInfoDto));
        hospitalRepository.save(hospital);
        return ResponseEntity.ok("Hospital info saved");
    }

    public ResponseEntity updateHospital(Long id, HospitalDto hospitalDto){

        Hospital updatedHospital = hospitalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hospital Not Found"));

        updatedHospital.setName(hospitalDto.name());

        hospitalRepository.save(updatedHospital);
        return ResponseEntity.ok("Hospital updated");
    }

    public ResponseEntity updateHospitalInfo(Long id, HospitalInfoDto dto){

        Hospital hospital = hospitalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hospital not found"));

        hospitalMapper.updateToEntity(dto, hospital.getHospitalInfo());
        hospitalRepository.save(hospital);

        return ResponseEntity.ok("Hospital Info updated");
    }

    public ResponseEntity deleteHospital(Long id){

        hospitalRepository.deleteById(id);

        return ResponseEntity.ok("Hospital deleted");
    }

}
