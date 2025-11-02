package com.hospital.springboot.RestContoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.springboot.dto.HospitalResponse;
import com.hospital.springboot.dto.Patient;
import com.hospital.springboot.entity.Hospital;
import com.hospital.springboot.external.service.PatientService;
import com.hospital.springboot.repository.HospitalRepository;

@RestController
@RequestMapping("/hospitals")
public class HospitalController {

	@Autowired
	private HospitalRepository hospitalRepository;

	@Autowired
	public PatientService patientService;
	
	@PostMapping
	public Hospital saveHospital(@RequestBody Hospital hospital) {
		return hospitalRepository.save(hospital);
	}

	@GetMapping
	public List<Hospital> getAllHospitals() {
		return hospitalRepository.findAll();
	}

	// This endpoint calls Patient Service using RestTemplate
	@GetMapping("/{hospitalId}/patients/{patientId}")
	public HospitalResponse getHospitalWithPatient(@PathVariable(name = "hospitalId") Long hospitalId,
			@PathVariable(name = "patientId") int patientId) {
		Hospital hospital = hospitalRepository.findById(hospitalId).orElse(null);
		if (hospital == null)
			return new HospitalResponse(null, null);

		
		Patient patient = patientService.getPatient(patientId);
		return new HospitalResponse(hospital, patient);
	}
}
