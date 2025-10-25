package com.hospital.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class HospitalNotFoundException extends RuntimeException{

	public HospitalNotFoundException(String msg)
	{
		super(msg);
	}
}
