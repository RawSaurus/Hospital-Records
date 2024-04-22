package com.example.hospitalrecords;

import com.example.hospitalrecords.auth.AuthenticationService;
import com.example.hospitalrecords.auth.RegisterRequest;
import com.example.hospitalrecords.role.model.RoleType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HospitalRecordsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalRecordsApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AuthenticationService service){
		return args -> {
			var admin = RegisterRequest.builder()
					.firstname("admin")
					.lastname("admin")
					.email("admin@mail.com")
					.password("admin")
					.roleType(RoleType.ADMIN)
					.build();
			System.out.println("Admin token: " + service.register(admin).getAccessToken());

			var receptionist = RegisterRequest.builder()
					.firstname("receptionist")
					.lastname("receptionist")
					.email("recep@mail.com")
					.password("recep")
					.roleType(RoleType.RECEPTIONIST)
					.build();
			System.out.println("Receptionist token: " + service.register(receptionist).getAccessToken());
		};
	}

}
