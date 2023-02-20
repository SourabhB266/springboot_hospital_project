package com.ty.springboot_hospital_project.exception;

public class EncounterNotFoundException extends RuntimeException{
	
private String message = "Encounter Not Found For This Id";
	
	@Override
	public String getMessage() {
		return message;
	}

	public EncounterNotFoundException(String message) {
		super();
		this.message = message;
	}

	public EncounterNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
