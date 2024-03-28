package com.example.hospitalrecords.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HospitalController {

    @GetMapping("/hospital")
    public String welcome(){
        return "Welcome in da Hospital";
    }
}
