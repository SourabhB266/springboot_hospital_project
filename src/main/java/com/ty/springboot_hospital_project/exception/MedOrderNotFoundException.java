package com.ty.springboot_hospital_project.exception;

public class MedOrderNotFoundException extends RuntimeException {
	
	private String message = "Medorder Not Found For This Id";

	@Override
	public String getMessage() {
		return message;
	}

	public MedOrderNotFoundException(String message) {
		super();
		this.message = message;
	}

	public MedOrderNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
