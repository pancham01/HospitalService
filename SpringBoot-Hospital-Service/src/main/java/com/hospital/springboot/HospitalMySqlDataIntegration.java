package com.hospital.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class HospitalMySqlDataIntegration {

	public static void main(String[] args) {
		
		System.out.println("HospitalMySqlDataIntegrationWithResponseEntityApplication.main()");
		SpringApplication.run(HospitalMySqlDataIntegration.class, args);
	}
}


