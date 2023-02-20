package com.ty.springboot_hospital_project.exception;

public class MedItemsNotFoundException extends RuntimeException{
	
	private String message = "MedItems Not Found For This Id";

	@Override
	public String getMessage() {
		return message;
	}

	public MedItemsNotFoundException(String message) {
		super();
		this.message = message;
	}

	public MedItemsNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
