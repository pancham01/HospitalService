package com.hospital.springboot.dto;

import com.hospital.springboot.entity.Hospital;

public class HospitalResponse {
	private Hospital hospital;
	private Patient patient;

	public HospitalResponse(Hospital hospital, Patient patient) {
		this.hospital = hospital;
		this.patient = patient;
	}

	// Getters and Setters
	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
