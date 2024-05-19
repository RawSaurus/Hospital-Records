package com.example.hospitalrecords.doctor.service;

import com.example.hospitalrecords.department.model.Department;
import com.example.hospitalrecords.department.repository.DepartmentRepository;
import com.example.hospitalrecords.doctor.dto.DoctorDto;
import com.example.hospitalrecords.doctor.mapper.DoctorMapper;
import com.example.hospitalrecords.doctor.model.Doctor;
import com.example.hospitalrecords.doctor.repository.DoctorRepository;
import com.example.hospitalrecords.patient.model.Patient;
import com.example.hospitalrecords.role.model.RoleType;
import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final DepartmentRepository departmentRepository;
    private final DoctorMapper doctorMapper;

    public DoctorDto getDoctor(Long id){
        return doctorMapper.toDoctorDto(doctorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found")));
    }

    public List<DoctorDto> getAllDoctors(){
        return doctorRepository.findAll()
                .stream()
                .map(doctorMapper::toDoctorDto)
                .collect(Collectors.toList());
    }

    public List<DoctorDto> getDoctorsFromDepartment(Long id){
      Department department = departmentRepository.findById(id)
              .orElseThrow(() -> new EntityNotFoundException("Department not found"));

      return department.getDoctors()
              .stream()
              .map(doctorMapper::toDoctorDto)
              .collect(Collectors.toList());
    }

    public ResponseEntity saveDoctor(DoctorDto doctor){ //TODO validate
        Doctor saveDoctor = doctorMapper.toEntity(doctor);
        saveDoctor.setRoleType(RoleType.DOCTOR);
        doctorRepository.save(saveDoctor);
        return ResponseEntity.ok("Doctor saved");
    }

    public ResponseEntity updateDoctorById(Long id, DoctorDto doctor){

        Doctor updatedDoctor = doctorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Doctor Not Found"));

        updatedDoctor.setFirstname(doctor.firstname());
        updatedDoctor.setLastname(doctor.lastname());
        updatedDoctor.setTitle(doctor.title());
        updatedDoctor.setEmail(doctor.email());
        updatedDoctor.setContact(doctor.contact());

        doctorRepository.save(updatedDoctor);

        return ResponseEntity.ok("Doctor updated");
    }

    public ResponseEntity deleteDoctorById(Long id){

        doctorRepository.deleteById(id);

        return ResponseEntity.ok("Doctor deleted");
    }

}
