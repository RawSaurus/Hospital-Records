package com.example.hospitalrecords.doctor.mapper;

import com.example.hospitalrecords.doctor.dto.DoctorDto;
import com.example.hospitalrecords.doctor.model.Doctor;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {

    public Doctor toEntity(DoctorDto doctorDto){
        if(doctorDto == null)
            return null;

        Doctor doctor = new Doctor();
        doctor.setFirstname(doctorDto.firstname());
        doctor.setLastname(doctorDto.lastname());
        doctor.setTitle(doctorDto.title());
        doctor.setEmail(doctorDto.email());
        doctor.setContact(doctorDto.contact());

        return doctor;
    }

    public DoctorDto toDoctorDto(Doctor doctor){
        if(doctor == null)
            return null;

        return new DoctorDto(
                doctor.getFirstname(),
                doctor.getLastname(),
                doctor.getTitle(),
                doctor.getEmail(),
                doctor.getContact()
        );
    }
}
