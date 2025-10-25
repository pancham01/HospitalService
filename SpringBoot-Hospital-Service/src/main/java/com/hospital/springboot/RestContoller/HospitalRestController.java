package com.hospital.springboot.RestContoller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.springboot.entity.Hospital;
import com.hospital.springboot.exception.HospitalNotFoundException;
import com.hospital.springboot.service.HospitalService;

@RestController
@RequestMapping(value = "/api")
public class HospitalRestController {

	private HospitalService hospitalService=null;
	
	public HospitalRestController(HospitalService hospitalService)
	{
		this.hospitalService = hospitalService;
	}
	

	@GetMapping(value = "/getHome")
	public ResponseEntity<String> getHome()
	{
		return ResponseEntity.status(HttpStatus.CREATED)
				.body("Home page called with @GetMapping and @ResponseEntity object");
	}

	@PostMapping(value = "/saveHospital")
	public ResponseEntity<Hospital> saveHospital(@RequestBody Hospital hospital) {
		return hospitalService.saveHospital(hospital);
	}
	
	@GetMapping(value = "/getHospitalById/{id}")
	public ResponseEntity getHospitalById(@PathVariable(value = "id") Long hospitalId) {
		Optional<Hospital> hospital = hospitalService.getHospitalById(hospitalId);
		
		if (hospital.isEmpty()) {
			throw new HospitalNotFoundException("This user is not available");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(hospital);
		}

	}

	@GetMapping(value = "/getAllHospitals")
	public ResponseEntity<List<Hospital>> getAllHospitals() {
		return hospitalService.getAllHospitals();
	}

	@PatchMapping(value = "/updateHospitalById/{id}")
	public ResponseEntity<Hospital> updateHospitalById(@RequestBody Hospital hospital, @PathVariable(value = "id") Long hospitalId) {
		return hospitalService.updateHospitalById(hospital, hospitalId);
	}

	@DeleteMapping(value = "/deleteHospitalById/{id}")
	public ResponseEntity<String> deleteHospitalById(@PathVariable(value = "id") Long hospitalId) {
		return hospitalService.deleteHospitalById(hospitalId);
	}
	
}
