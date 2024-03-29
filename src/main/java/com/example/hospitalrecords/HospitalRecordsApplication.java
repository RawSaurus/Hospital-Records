package com.example.hospitalrecords;

import com.example.hospitalrecords.model.Hospital;
import com.example.hospitalrecords.repository.HospitalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HospitalRecordsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalRecordsApplication.class, args);
	}

}
