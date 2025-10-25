package com.hospital.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hospital.springboot.entity.Hospital;
import com.hospital.springboot.repository.HospitalRepository;

@Service
public class HospitalServiceImplementation implements HospitalService{

	private HospitalRepository hospitalRepo;
	
	public HospitalServiceImplementation(HospitalRepository hospitalRepo)
	{
		this.hospitalRepo= hospitalRepo;
		
	}
	
	@Override
	public ResponseEntity<Hospital> saveHospital(Hospital hospital)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(hospitalRepo.save(hospital));
	}
	
	@Override
	public Optional<Hospital> getHospitalById(Long hospitalId)
	{
		Optional<Hospital> hospitalById = hospitalRepo.findById(hospitalId);
		return hospitalById;
	}
	
	@Override
	public ResponseEntity <List<Hospital>> getAllHospitals()
	{
		try {
			return ResponseEntity.status(HttpStatus.OK).body(hospitalRepo.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@Override
	public ResponseEntity <String> deleteHospitalById(Long hospitalId)
	{
		Optional <Hospital> hospital= hospitalRepo.findById(hospitalId);
		
		if(hospital.isPresent())
		{
			hospitalRepo.deleteById(hospitalId);
			return ResponseEntity.status(HttpStatus.OK).body("Hospital with given id is deleted successfully");
		}
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
					
	}
	
	@Override
	public ResponseEntity <Hospital> updateHospitalById(Hospital hospitalNew,Long hospitalId)
	{
		Optional<Hospital> gethospitalById=hospitalRepo.findById(hospitalId);
		
		if(gethospitalById.isPresent())
		{
			Hospital updateHospital=gethospitalById.get();
			updateHospital.setHospitalName(hospitalNew.getHospitalName());
			updateHospital.setHospitalEmail(hospitalNew.getHospitalEmail());
			updateHospital.setHospitalCity(hospitalNew.getHospitalCity());
			updateHospital.setHospitalContact(hospitalNew.getHospitalContact());
			
			return ResponseEntity.status(HttpStatus.OK).body(hospitalRepo.save(updateHospital));
						
		}
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
	}
	
}
