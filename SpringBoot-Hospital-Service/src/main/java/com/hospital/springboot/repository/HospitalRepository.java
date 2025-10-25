package com.hospital.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.springboot.entity.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {

}