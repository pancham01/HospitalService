package com.hospital.springboot.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hospital.springboot.dto.Patient;

@FeignClient(name = "PATIENT-SERVICE")
public interface PatientService {
	
	@GetMapping("/patients/{id}")
	public Patient getPatient(@PathVariable(name = "id") int id);
	
}
