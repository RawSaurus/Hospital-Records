package com.example.hospitalrecords.test.service;

import com.example.hospitalrecords.patient.model.Patient;
import com.example.hospitalrecords.patient.repository.PatientRepository;
import com.example.hospitalrecords.test.dto.TestDto;
import com.example.hospitalrecords.test.mapper.TestMapper;
import com.example.hospitalrecords.test.model.Test;
import com.example.hospitalrecords.test.repository.TestRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class TestService {

    private final TestRepository testRepository;
    private final PatientRepository patientRepository;
    private final TestMapper testMapper;

    public TestDto getTest(Long id, String testName){
      return   testMapper.toTestDto(patientRepository.findById(id)
              .orElseThrow(() -> new EntityNotFoundException("Patient not found"))
              .getTests()
              .stream()
              .filter((Test test) -> test.getName().equals(testName))
              .findFirst()
              .orElseThrow(() -> new EntityNotFoundException("Test not found")));

    }

    public List<TestDto> getAllTests(Long id){
        return patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found"))
                .getTests()
                .stream()
                .map(testMapper::toTestDto)
                .collect(Collectors.toList());
    }

    public TestDto postTest(Long id, TestDto testDto){
       Test test = testMapper.toEntity(testDto);
       Patient patient = patientRepository.findById(id)
               .orElseThrow(() -> new EntityNotFoundException("Patient not found"));

//       test.setPatient(patient);
       patient.getTests().add(test);
       patientRepository.save(patient);

       return testDto;
    }

    public ResponseEntity updateTest(Long id,Long testId, TestDto testDto){

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found"));

        for(int i = 0; i<patient.getTests().size(); i++){
            if(patient.getTests().get(i).getTestId().equals(testId)){
               testMapper.updateToEntity(testDto, patient.getTests().get(i));
               patientRepository.save(patient);
               break;
            }
        }


        return ResponseEntity.ok("Test updated");
    }


    public ResponseEntity deleteTest(Long id, Long testId){
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found"));

        for(int i = 0; i<patient.getTests().size(); i++){
            if(patient.getTests().get(i).getTestId().equals(testId)) {
                patient.getTests().remove(i);
                patientRepository.save(patient);
                testRepository.deleteById(testId);
                break;
            }
        }
        return ResponseEntity.ok("Deleted successfully");
    }
}


