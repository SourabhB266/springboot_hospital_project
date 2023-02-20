package com.ty.springboot_hospital_project.exception;

public class PersonNotFoundException extends RuntimeException{
	
	private String message = "Person Not Found For This Id";

	@Override
	public String getMessage() {
		return message;
	}

	public PersonNotFoundException(String message) {
		super();
		this.message = message;
	}

	public PersonNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
