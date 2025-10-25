package com.hospital.springboot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_table")
public class Hospital {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long hospitalId;
	
	private String hospitalName;
	private String hospitalEmail;
	private String hospitalCity;
	private String hospitalContact;
	
	
	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Hospital(String hospitalName, String hospitalEmail, String hospitalCity,
			String hospitalContact) {
		super();
		this.hospitalName = hospitalName;
		this.hospitalEmail = hospitalEmail;
		this.hospitalCity = hospitalCity;
		this.hospitalContact = hospitalContact;
	}


	public long getHospitalId() {
		return hospitalId;
	}


	public void setHospitalId(long hospitalId) {
		this.hospitalId = hospitalId;
	}


	public String getHospitalName() {
		return hospitalName;
	}


	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}


	public String getHospitalEmail() {
		return hospitalEmail;
	}


	public void setHospitalEmail(String hospitalEmail) {
		this.hospitalEmail = hospitalEmail;
	}


	public String getHospitalCity() {
		return hospitalCity;
	}


	public void setHospitalCity(String hospitalCity) {
		this.hospitalCity = hospitalCity;
	}


	public String getHospitalContact() {
		return hospitalContact;
	}


	public void setHospitalContact(String hospitalContact) {
		this.hospitalContact = hospitalContact;
	}


	@Override
	public String toString() {
		return "Hospital [hospitalId=" + hospitalId + ", hospitalName=" + hospitalName + ", hospitalEmail="
				+ hospitalEmail + ", hospitalCity=" + hospitalCity + ", hospitalContact=" + hospitalContact + "]";
	}
	
	
}
