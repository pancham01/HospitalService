package com.hospital.springboot.service;

import org.springframework.http.ResponseEntity;

import java.util.Optional;
import java.util.List;
import com.hospital.springboot.entity.Hospital;

public interface HospitalService {

	public ResponseEntity<Hospital> saveHospital(Hospital hospital);
	
	public Optional<Hospital> getHospitalById(Long hospitalId);
	
	public ResponseEntity<List<Hospital>> getAllHospitals();
	
	public ResponseEntity <String> deleteHospitalById(Long hospitalId);
	
	public ResponseEntity <Hospital> updateHospitalById(Hospital hospital,Long hospitalId);
	
	
}
