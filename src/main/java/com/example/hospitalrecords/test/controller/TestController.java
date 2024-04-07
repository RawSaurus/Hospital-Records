package com.example.hospitalrecords.test.controller;

import com.example.hospitalrecords.test.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tests")
public class TestController {

    private final TestService testService;

    public TestController(TestService testService){
        this.testService = testService;
    }
}
