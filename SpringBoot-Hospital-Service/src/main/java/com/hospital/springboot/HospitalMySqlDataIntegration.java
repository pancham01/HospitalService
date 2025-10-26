package com.hospital.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class HospitalMySqlDataIntegration {

	public static void main(String[] args) {
		
		System.out.println("HospitalMySqlDataIntegrationWithResponseEntityApplication.main()");
		SpringApplication.run(HospitalMySqlDataIntegration.class, args);
	}
	
	
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}


