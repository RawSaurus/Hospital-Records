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

//todo implement functionality

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
       Patient patient = patientRepository.findById(id).get();
       test.setPatient(patient);
       List<Test> listOfTest = patient.getTests();
       listOfTest.add(test);
       patient.setTests(listOfTest);
       patientRepository.save(patient);//TODO doesn't add tests to patient list


//       test.setPatient(patientRepository.findById(id)
//               .orElseThrow(() -> new EntityNotFoundException("Patient not found")));
//       testRepository.save(test);//TODO also save to patients tests list

       return testDto;
    }

    public TestDto updateTest(Long id,String testName, TestDto testDto){
//        Test updatedTest = testRepository.findByUserIdAndName(id,testName)
//                .orElseThrow(() -> new EntityNotFoundException("Test not found"));
//        updatedTest = testMapper.toEntity(testDto); //todo test and improve
//        testRepository.save(updatedTest);
//        return testMapper.toTestDto(updatedTest);
        return null;
    }


    public ResponseEntity deleteTest(Long id){
        testRepository.deleteById(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}


