package com.example.hospitalrecords.test.service;

import com.example.hospitalrecords.test.repository.TestRepository;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private TestRepository testRepository;

    public TestService(TestRepository testRepository){
        this.testRepository = testRepository;
    }
}
