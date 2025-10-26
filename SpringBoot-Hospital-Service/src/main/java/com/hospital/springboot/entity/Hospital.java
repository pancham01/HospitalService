package com.hospital.springboot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_table")
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String city;
	private int noOfBeds;

	public Hospital() {
		super();
	}

	public Hospital(Long id, String name, String city, int noOfBeds) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.noOfBeds = noOfBeds;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getNoOfBeds() {
		return noOfBeds;
	}

	public void setNoOfBeds(int noOfBeds) {
		this.noOfBeds = noOfBeds;
	}

	@Override
	public String toString() {
		return "Hospital [id=" + id + ", name=" + name + ", city=" + city + ", noOfBeds=" + noOfBeds + "]";
	}

}
