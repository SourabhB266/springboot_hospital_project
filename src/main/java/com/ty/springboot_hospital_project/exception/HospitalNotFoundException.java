package com.ty.springboot_hospital_project.exception;

public class HospitalNotFoundException extends RuntimeException{
	
	private String message = "Hospital Not Found For This Id";

	@Override
	public String getMessage() {
		return message;
	}

	public HospitalNotFoundException(String message) {
		super();
		this.message = message;
	}

	public HospitalNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
